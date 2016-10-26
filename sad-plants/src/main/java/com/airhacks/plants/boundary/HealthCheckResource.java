package com.airhacks.plants.boundary;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
    public Response save(JsonObject status, @Context UriInfo info) {
        System.out.println("status = " + status);
        URI path = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(path).build();
    }

    @GET
    @Path("{id}")
    public JsonObject status(@PathParam("id") long id) {
        return Json.createObjectBuilder().add("id", id).build();
    }

}
