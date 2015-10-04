package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcd on 04/10/2015.
 */
@Path("/users")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface UserService {

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    Response createNewUser(String name);

    @GET
    public Response getAllUser();

    @Path("/{name}")
    @GET
    public Response getUserId(@PathParam("name") String name);

    @Path("/{name}")
    @DELETE
    public Response deleteUser(@PathParam("name") String name);
}