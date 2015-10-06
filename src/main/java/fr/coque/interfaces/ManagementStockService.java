package fr.coque.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcd on 06/10/2015.
 */
@Path("/managementStock")
// Here we generate JSON data from scratch, one should use a framework instead
@Produces(MediaType.APPLICATION_JSON)
public interface ManagementStockService {

    @GET
    Response getWoodQuantity();

    @PUT
    Response updateWoodQuantity(@QueryParam("woodQuantity") int woodQuantity);
}
