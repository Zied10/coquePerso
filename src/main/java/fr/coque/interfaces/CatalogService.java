package fr.coque.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Zizou on 05/10/2015.
 */
@Path("/catalog")
@Produces(MediaType.APPLICATION_JSON)
public interface CatalogService {

    @GET
    Response getCatalog();

    @Path("/models")
    @GET
    Response getModels();

    @Path("/motifs")
    @GET
    Response getMotifs();

}
