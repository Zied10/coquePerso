package fr.coque.interfaces;

import fr.coque.entities.Commande;
import fr.coque.entities.Product;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by marcd on 04/10/2015.
 */
@Path("/commandes")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface CommandeService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewCommande(String jsonInput);


    @GET
    public Response getAllCommandes();

    @Path("/{id}")
    @GET
    public Response getIdCommandeFrom(@PathParam("id") int id);


    @Path("/{id}")
    @DELETE
    public Response deleteCommande(@PathParam("id") int id);

    @Path("/{id}/state")
    @GET
    public Response getState(@PathParam("id") int id);

    @Path("/{id}/{state}")
    @PUT
    public Response getState(@PathParam("id") int id, @PathParam("state") int state);
}
