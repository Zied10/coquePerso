package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcd on 05/10/2015.
 */
@Path("/orderTracking")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface OrderTrackingService {

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    Response createNewOrderTracking(int orderId);

    @GET
    Response getAllOrderTracking();

    /*@Path("/{orderId}")
    @GET
    Response getOrderId(@PathParam("orderId") int orderId);*/

    @Path("/{orderId}")
    @DELETE
    Response deleteOrderTracking(@PathParam("orderId") int orderId);

    @Path("/{orderId}/state")
    @GET
    Response getState(@PathParam("orderId") int orderId);

    @Path("/{orderId}/{state}")
    @PUT
    Response setState(@PathParam("orderId") int orderId, @PathParam("state") int state);
}
