package com.airhacks.plants.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("health")
public class HealthCheckResource {

    @Inject
    HealthMonitor hm;

    @GET
    public JsonObject health() {
        return Json.createObjectBuilder().
                add("health", this.hm.state()).
                build();
    }

    @POST
    public void save(JsonObject status) {
        System.out.println("status = " + status);
    }

}
