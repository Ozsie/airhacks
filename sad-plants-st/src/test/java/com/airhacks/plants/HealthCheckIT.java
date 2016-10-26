package com.airhacks.plants;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class HealthCheckIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/sad-plants/resources/health");
    }

    @Test
    public void healthCheck() {
        Response response = this.tut.request().get();
        assertThat(response.getStatus(), is(200));
        JsonObject result = response.readEntity(JsonObject.class);
        assertNotNull(result);
        String expected = "dry";
        String actual = result.getString("health", null);
        assertThat(actual, startsWith(expected));
    }

    @Test
    public void saveStatus() {
        JsonObject input = Json.createObjectBuilder().
                add("status", "from test for kits").
                build();
        Response response = this.tut.request().
                post(Entity.json(input));
        assertThat(response.getStatusInfo().getFamily(),
                is(Response.Status.Family.SUCCESSFUL));
        assertThat(response.getStatus(), is(201));
        String locationHeader = response.getHeaderString("Location");
        assertNotNull(locationHeader);
        System.out.println("locationHeader = " + locationHeader);

        JsonObject status = this.client.
                target(locationHeader).
                request().
                get(JsonObject.class);
        assertNotNull(status);
    }

}
