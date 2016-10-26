package com.airhacks.plants;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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

}