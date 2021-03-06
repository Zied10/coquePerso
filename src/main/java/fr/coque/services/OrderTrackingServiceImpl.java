package fr.coque.services;

import fr.coque.entities.OrderTracking;
import fr.coque.interfaces.OrderTrackingService;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by marcd on 05/10/2015.
 */
public class OrderTrackingServiceImpl implements OrderTrackingService {
    public Response createNewOrderTracking(int orderId) {
        if(Storage.getOrderTracking(orderId) != null) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("\"Existing orderTracking " + orderId + "\"")
                    .build();
        }
        if(Storage.getOrderFromId(orderId) == null){
            return Response.status(Response.Status.CONFLICT)
                    .entity("\"Non Existing order with id " + orderId + "\"")
                    .build();
        }
        Storage.createOrderTracking(orderId);
        return Response.ok().build();
    }

    public Response getAllOrderTracking() {
        Collection<OrderTracking> orderTrackings = Storage.getAllOrderTrackings();
        JSONArray result = new JSONArray();
        for(OrderTracking o: orderTrackings) {
            result.put(new JSONObject(o.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response deleteOrderTracking(int orderId) {
        if(Storage.getOrderTracking(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.deleteOrderTracking(orderId);
        return Response.ok().build();
    }

    public Response getState(int orderId) {
        if(Storage.getOrderTracking(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        OrderTracking orderTracking = Storage.getOrderTracking(orderId);
        return Response.ok().entity(orderTracking.getState()).build();
    }

    public Response setState(int orderId, int state) {
        if(Storage.getOrderTracking(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        OrderTracking orderTracking = Storage.getOrderTracking(orderId);
        if(state != 0) {
            orderTracking.setState(state);
        }
        return Response.ok().build();
    }
}
