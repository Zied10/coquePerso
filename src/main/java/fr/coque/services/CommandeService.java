package fr.coque.services;

import fr.coque.Commande;
import fr.coque.storage.Storage;
import org.json.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Marc on 28/09/2015.
 */
@Path("/commandes")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public class CommandeService {


    @POST
    @Path("/{clientId}/{address}")
    public Response createNewCommande(@PathParam("clientId") int clientId, @PathParam("address") String address) {

        Storage.createCommande(Commande.getIdent(), clientId, address);
        return Response.ok().build();
    }

    @GET
    public Response getAllCommandes() {
        Collection<Commande> commandes = Storage.getAllCommandes();
        JSONArray result = new JSONArray();
        for(Commande c: commandes) {
            result.put(c.getId());
            result.put(c.getUserId());
            result.put(c.getAddress());
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
        return Response.ok().entity(commande.getUserId()).build();
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
}
