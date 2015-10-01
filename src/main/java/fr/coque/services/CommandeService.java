package fr.coque.services;

import fr.coque.Commande;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Created by Marc on 28/09/2015.
 */
@Path("/commandes")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public class CommandeService {

    @GET
    public Response getAllCommandes() {
        Collection<Commande> commandes = Storage.getAllCommandes();
        JSONArray result = new JSONArray();
        for(Commande c: commandes) {
            result.put(c.getId());
            result.put(c.getUserId());
            result.put(c.getAddress());
            result.put(c.getNumCard());
            result.put(c.getExpirationDate());
            result.put(c.getPictogram());
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    @Path("/{id}")
    @GET
    public Response getIdCommandeFrom(@PathParam("id") int id) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Commande commande = Storage.getCommandeFromId(id);

        JSONArray result = new JSONArray();
        result.put(commande.getId());
        result.put(commande.getPrice());
        result.put(commande.getAddress());
        result.put(commande.getState());
        result.put(commande.getUserId());

        return Response.ok().entity(result.toString(2)).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteCommande(@PathParam("id") int id) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.deleteCommande(id);
        return Response.ok().build();
    }

    @Path("/{id}/state")
    @GET
    public Response getState(@PathParam("id") int id) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Commande commande = Storage.getCommandeFromId(id);
        return Response.ok().entity(commande.getState()).build();
    }

    @Path("/{id}/{state}")
    @PUT
    public Response getState(@PathParam("id") int id, @PathParam("state") int state) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Commande commande = Storage.getCommandeFromId(id);
        commande.setState(state);
        return Response.ok().build();
    }
}
