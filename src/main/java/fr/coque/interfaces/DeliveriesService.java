package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcd on 05/10/2015.
 */
@Path("/deliveries")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface DeliveriesService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response createNewDelivery(String jsonInput);

    @GET
    Response getAllDeliveries();

    @Path("/{orderId}")
    @DELETE
    Response deleteDelivery(@PathParam("orderId") int orderId);

    @Path("/{orderId}/address")
    @GET
    Response getAddress(@PathParam("orderId") int orderId);

    @Path("/{orderId}/departureDate")
    @GET
    Response getDepartureDate(@PathParam("orderId") int orderId);

    @Path("/{orderId}/arrivalDate")
    @GET
    Response getArrivalDate(@PathParam("orderId") int orderId);

    @Path("/{orderId}/arrivalDate")
    @PUT
    Response setArrivalDate(@PathParam("orderId") int orderId, @QueryParam("arrivalDate") String arrivalDate);

    @Path("/{orderId}/state")
    @GET
    Response getState(@PathParam("orderId") int orderId);

    @Path("/{orderId}/state")
    @PUT
    Response setState(@PathParam("orderId") int orderId, @QueryParam("state") int state);
}
