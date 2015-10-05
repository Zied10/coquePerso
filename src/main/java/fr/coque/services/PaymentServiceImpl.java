package fr.coque.services;

import fr.coque.entities.Payment;
import fr.coque.interfaces.PaymentService;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Zizou on 05/10/2015.
 */
public class PaymentServiceImpl implements PaymentService{
    public Response newPayment(String jsonInput) {
        JSONObject jsonObj = new JSONObject(jsonInput);
        if(Storage.getOrderFromId(jsonObj.getInt("orderId")) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.createPayment(jsonObj.getInt("orderId"), jsonObj.getInt("numCard"), jsonObj.getString("expirationDate"),jsonObj.getInt("pictogram"), (float)jsonObj.getDouble("price"));
        return Response.ok().build();
    }

    public Response getAllPayment() {
        Collection<Payment> payments = Storage.getAllPayment();
        JSONArray result = new JSONArray();
        for(Payment p: payments) {
            result.put(new JSONObject(p.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response getPaymentById(int id) {
        if(Storage.getPaymentFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Payment payment = Storage.getPaymentFromId(id);
        JSONObject result = new JSONObject(payment.toString());
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response deletePayment(int id) {
        if(Storage.getPaymentFromId(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Storage.deletePayment(id);
        return Response.ok().build();
    }
}
