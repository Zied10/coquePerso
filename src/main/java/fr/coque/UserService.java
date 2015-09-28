package fr.coque;

import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/users")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public Response createNewUser(String name) {
	    if(Storage.read(name) != null) {
			return Response.status(Response.Status.CONFLICT)
					       .entity("\"Existing name " + name + "\"")
					       .build();
		}
		Storage.create(name);
		return Response.ok().build();
	}

	@GET
	public Response getAllUser() {
		Collection<User> gens = Storage.findAll();
		JSONArray result = new JSONArray();
		for(User g: gens) {
			result.put(g.getName());
		}
		return Response.ok().entity(result.toString(2)).build();
	}


	@Path("/{name}")
	@DELETE
	public Response deleteUser(@PathParam("name") String name) {
		if(Storage.read(name) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Storage.delete(name);
		return Response.ok().build();
	}

}
