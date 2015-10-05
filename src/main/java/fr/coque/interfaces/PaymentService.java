package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Zizou on 05/10/2015.
 */

@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
public interface PaymentService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response newPayment(String jsonInput);

    @GET
    Response getAllPayment();

    @Path("/{id}")
    @GET
    Response getPaymentById(@PathParam("id") int id);

    @Path("/{id}")
    @DELETE
    Response deletePayment(@PathParam("id") int id);


}
