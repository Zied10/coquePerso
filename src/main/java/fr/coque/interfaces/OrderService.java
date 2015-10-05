package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcd on 04/10/2015.
 */
@Path("/orders")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface OrderService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewOrder(String jsonInput);


    @GET
    public Response getAllOrders();

    @Path("/{id}")
    @GET
    public Response getIdOrderFrom(@PathParam("id") int id);


    @Path("/{id}")
    @DELETE
    public Response deleteOrder(@PathParam("id") int id);

    @Path("/{id}/state")
    @GET
    public Response getState(@PathParam("id") int id);

    @Path("/{id}/{state}")
    @PUT
    public Response getState(@PathParam("id") int id, @PathParam("state") int state);
}
