package fr.coque.services;

import fr.coque.entities.Assembly;
import fr.coque.entities.Delivery;
import fr.coque.interfaces.AssemblyService;
import fr.coque.storage.Storage;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created by Zizou on 06/10/2015.
 */
public class AssemblyServiceImpl implements AssemblyService {
    public Response assembleProduct(String jsonInput) {
        JSONObject jsonObj = new JSONObject(jsonInput);
        int orderId = jsonObj.getInt("orderId");
        if(Storage.getAssemblyById(orderId) != null) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("\"Existing assembly " + orderId + "\"")
                    .build();
        }
        Storage.createAssembly(orderId);
        return Response.ok().build();
    }

    public Response getAssemblyDurationById(int orderId) {
        if(Storage.getAssemblyById(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response.ok().entity(Storage.getAssemblyById(orderId).getAssemblyDuration()).build();
    }


    public Response getAllAssemblies() {
        Collection<Assembly> assemblies = Storage.getAllAssembly();
        JSONArray result = new JSONArray();
        for(Assembly a: assemblies) {
            result.put(new JSONObject(a.toString()));
        }
        return Response.ok().entity(result.toString(2)).build();
    }

    public Response getAssemblyFromId(int orderId) {
        if(Storage.getAssemblyById(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response.ok().entity(Storage.getAssemblyById(orderId).toString()).build();
    }

    public Response updateAssembly(int orderId, int duration, int state) {
        if(Storage.getAssemblyById(orderId) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Assembly assembly = Storage.getAssemblyById(orderId);
        if(duration > 0) {
            assembly.setAssemblyDuration(duration);
        }
        if(state != 0) {
            assembly.setState(state);
        }
        return Response.ok().build();
    }
}
