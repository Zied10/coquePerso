package fr.coque.services;

import fr.coque.entities.Commande;
import fr.coque.entities.Product;
import fr.coque.interfaces.CommandeService;
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
 * Created by Marc on 28/09/2015.
 */
public class CommandeServiceImpl implements CommandeService{

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
        Storage.createCommande(Commande.getIdent(), jsonObj.getInt("clientId"),
                jsonObj.getString("address"), productList, jsonObj.getInt("numCard"),
                jsonObj.getString("expirationDate"), jsonObj.getInt("pictogram"), jsonObj.getInt("livraison"));
        return Response.ok().build();
    }

    public Response getAllCommandes() {
        Collection<Commande> commandes = Storage.getAllCommandes();
        JSONArray result = new JSONArray();
        for(Commande c: commandes) {
            result.put(new JSONObject(c.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response getIdCommandeFrom(int id) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Commande commande = Storage.getCommandeFromId(id);
        JSONObject result = new JSONObject(commande.toString());
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response deleteCommande(int id) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.deleteCommande(id);
        return Response.ok().build();
    }

    public Response getState(int id) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Commande commande = Storage.getCommandeFromId(id);
        return Response.ok().entity(commande.getState()).build();
    }

    public Response getState(int id, int state) {
        if(Storage.getCommandeFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Commande commande = Storage.getCommandeFromId(id);
        commande.setState(state);
        return Response.ok().build();
    }
}
