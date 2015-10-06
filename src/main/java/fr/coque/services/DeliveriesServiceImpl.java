package fr.coque.services;

import fr.coque.entities.Delivery;
import fr.coque.interfaces.DeliveriesService;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by marcd on 05/10/2015.
 */
public class DeliveriesServiceImpl implements DeliveriesService {

    public Response createNewDelivery(String jsonInput) {
        JSONObject jsonObj = new JSONObject(jsonInput);
        int orderId = jsonObj.getInt("orderId");
        String address = jsonObj.getString("address");
        int deliveryType = jsonObj.getInt("deliveryType");
        if(Storage.getDelivery(orderId) != null) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("\"Existing delivery " + orderId + "\"")
                    .build();
        }
        if(Storage.getOrderFromId(orderId) == null) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("\"Non Existing order " + orderId + "\"")
                    .build();
        }
        Storage.createDelivery(orderId, address, deliveryType);
        return Response.ok().build();
    }

    public Response getAllDeliveries() {
        Collection<Delivery> deliveries = Storage.getAlldeliveries();
        JSONArray result = new JSONArray();
        for(Delivery d: deliveries) {
            result.put(new JSONObject(d.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response deleteDelivery(int orderId) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.deleteDelivery(orderId);
        return Response.ok().build();
    }

    public Response getAddress(int orderId) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Delivery delivery = Storage.getDelivery(orderId);
        return Response.ok().entity(delivery.getAddress()).build();
    }

    public Response getDepartureDate(int orderId) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Delivery delivery = Storage.getDelivery(orderId);
        return Response.ok().entity(delivery.getOrderDate()).build();
    }

    public Response getArrivalDate(int orderId) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Delivery delivery = Storage.getDelivery(orderId);
        return Response.ok().entity(delivery.getArrivalDate()).build();
    }

    public Response getDeliveryDuration(int orderId) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Delivery delivery = Storage.getDelivery(orderId);
        return Response.ok().entity(delivery.getDeliveryDuration()).build();
    }

    public Response getState(int orderId) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Delivery delivery = Storage.getDelivery(orderId);
        return Response.ok().entity(delivery.getState()).build();
    }

    public Response updateDelivery(int orderId, int state, String arrivalDate, int deliveryDuration) {
        if(Storage.getDelivery(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Delivery delivery = Storage.getDelivery(orderId);
        if(arrivalDate != null) {
            delivery.setArrivalDate(arrivalDate);
        }
        if(state != 0) {
            delivery.setState(state);
        }
        if(deliveryDuration != 0){
            delivery.setDeliveryDuration(deliveryDuration);
        }
        return Response.ok().build();
    }
}
