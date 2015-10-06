package fr.coque.services;

import fr.coque.entities.Order;
import fr.coque.entities.Product;
import fr.coque.interfaces.OrderService;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Marc on 28/09/2015.
 */
public class OrderServiceImpl implements OrderService {

    public Response createNewOrder(String jsonInput) {
        JSONObject jsonObj = new JSONObject(jsonInput);
        List<Product> productList = new ArrayList<Product>();
        for (int i =0; i < jsonObj.getJSONArray("products").length(); i++){
            int tmpModel = jsonObj.getJSONArray("products").getJSONObject(i).getInt("idModel");
            int tmpMotif = jsonObj.getJSONArray("products").getJSONObject(i).getInt("idMotif");
            Product tmp = new Product(tmpModel, tmpMotif);
            tmp.setPrice(Storage.getModelFromId(tmpModel).getPrice() + (Storage.getMotifFromId(tmpMotif).getPrice()));
            productList.add(tmp);

        }
        Storage.createOrder(Order.getIdent(),
                jsonObj.getInt("clientId"),
                productList,
                jsonObj.getInt("livraison"));
        return Response.ok().build();
    }

    public Response getAllOrders() {
        Collection<Order> orders = Storage.getAllOrders();
        JSONArray result = new JSONArray();
        for(Order c: orders) {
            result.put(new JSONObject(c.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response getIdOrderFrom(int id) {
        if(Storage.getOrderFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Order order = Storage.getOrderFromId(id);
        JSONObject result = new JSONObject(order.toString());
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response deleteOrder(int id) {
        if(Storage.getOrderFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.deleteOrder(id);
        return Response.ok().build();
    }

    public Response getState(int id) {
        if(Storage.getOrderFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Order order = Storage.getOrderFromId(id);
        return Response.ok().entity(order.getState()).build();
    }

    public Response getState(int id, int state) {
        if(Storage.getOrderFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Order order = Storage.getOrderFromId(id);
        if(state != 0) {
            order.setState(state);
        }
        return Response.ok().build();
    }
}
