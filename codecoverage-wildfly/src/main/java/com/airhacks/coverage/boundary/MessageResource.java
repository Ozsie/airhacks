package com.airhacks.coverage.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("message")
public class MessageResource {

    @Inject
    MessageService ms;

    @GET
    public String message() {
        return ms.goodMorning();
    }

}
