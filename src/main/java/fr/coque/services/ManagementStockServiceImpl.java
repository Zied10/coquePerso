package fr.coque.services;

import fr.coque.interfaces.ManagementStockService;
import fr.coque.storage.Storage;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

/**
 * Created by marcd on 06/10/2015.
 */
public class ManagementStockServiceImpl implements ManagementStockService{
    public Response getWoodQuantity() {
        int woodQuantity = Storage.getWoodQuantity();
        return Response.ok().entity(woodQuantity).build();
    }

    public Response updateWoodQuantity(int woodQuantity) {
        if(woodQuantity !=0) {
            Storage.setWoodQuantity(woodQuantity);
        }
        return Response.ok().build();
    }
}
