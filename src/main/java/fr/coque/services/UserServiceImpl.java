package fr.coque.services;

import fr.coque.interfaces.UserService;
import fr.coque.storage.Storage;
import fr.coque.entities.User;
import org.json.JSONArray;

import javax.ws.rs.core.Response;
import java.util.Collection;

public class UserServiceImpl implements UserService{

	public Response createNewUser(String name) {
		if(Storage.getUser(name) != null) {
			return Response.status(Response.Status.CONFLICT)
					.entity("\"Existing name " + name + "\"")
					.build();
		}
		Storage.createUser(name);
		return Response.ok().build();
	}

	public Response getAllUser() {
		Collection<User> gens = Storage.getAllUsers();
		JSONArray result = new JSONArray();
		for(User g: gens) {
			result.put(g.getName());
		}
		return Response.ok().entity(result.toString(2)).build();
	}

	public Response getUserId(String name) {
		if(Storage.getUser(name) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		int value = Storage.getUserId(name);
		return Response.ok().entity("\""+value+"\"").build();
	}

	public Response deleteUser(String name) {
		if(Storage.getUser(name) == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Storage.deleteUser(name);
		return Response.ok().build();
	}
}
