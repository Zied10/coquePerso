package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcd on 04/10/2015.
 */
@Path("/assembly")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface AssemblyService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response assembleProduct(String jsonInput);

    @GET
    @Path("/duration/{orderId}")
    Response getAssemblyDurationById(@PathParam("orderId") int orderId);


    @GET
    Response getAllAssemblies();

    @GET
    @Path("/{orderId}")
    Response getAssemblyFromId(@PathParam("orderId") int orderId);

    @PUT
    @Path("/{orderId}")
    Response updateAssembly(@PathParam("orderId") int orderId, @QueryParam("duration") int duration, @QueryParam("state") int state);
}
