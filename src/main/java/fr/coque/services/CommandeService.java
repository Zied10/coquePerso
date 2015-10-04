package fr.coque.services;

import fr.coque.Commande;
import fr.coque.Product;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Marc on 28/09/2015.
 */
@Path("/commandes")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public class CommandeService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewCommande(String jsonInput) {
        JSONObject jsonObj = new JSONObject(jsonInput);
        List<Product> productList = new ArrayList<Product>();

        for (int i =0; i < jsonObj.getJSONArray("products").length(); i++){
            int tmpModel = jsonObj.getJSONArray("products").getJSONObject(i).getInt("idModel");
            int tmpMotif = jsonObj.getJSONArray("products").getJSONObject(i).getInt("idMotif");
            Product tmp = new Product(tmpModel, tmpMotif);
            tmp.setPrice(Storage.getModelFromId(tmpModel).getPrice() + (Storage.getMotifFromId(tmpMotif).getPrice()));
            productList.add(tmp);

        }

        Storage.createCommande(Commande.getIdent(), jsonObj.getInt("clientId"), jsonObj.getString("address"), productList, jsonObj.getInt("numCard"), jsonObj.getString("expirationDate"), jsonObj.getInt("pictogram"));
        return Response.ok().build();
    }


    @GET
    public Response getAllCommandes() {
        Collection<Commande> commandes = Storage.getAllCommandes();
        JSONArray result = new JSONArray();
        for(Commande c: commandes) {
            result.put(new JSONObject(c.toString()));
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
        JSONObject result = new JSONObject(commande.toString());
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
