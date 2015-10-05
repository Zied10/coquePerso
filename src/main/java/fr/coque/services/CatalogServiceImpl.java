package fr.coque.services;

import fr.coque.entities.Model;
import fr.coque.entities.Motif;
import fr.coque.entities.Order;
import fr.coque.interfaces.CatalogService;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Zizou on 05/10/2015.
 */
public class CatalogServiceImpl implements CatalogService{
    public Response getCatalog() {
        Collection<Model> models = Storage.getAllModel();
        Collection<Motif> motifs = Storage.getAllMotif();
        JSONArray result = new JSONArray();
        for(Model m: models) {
            result.put(new JSONObject(m.toString()));
        }
        for(Motif m: motifs) {
            result.put(new JSONObject(m.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response getModels() {
        Collection<Model> models = Storage.getAllModel();
        JSONArray result = new JSONArray();
        for(Model m: models) {
            result.put(new JSONObject(m.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response getMotifs() {
        Collection<Motif> motifs = Storage.getAllMotif();
        JSONArray result = new JSONArray();
        for(Motif m: motifs) {
            result.put(new JSONObject(m.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }
}
