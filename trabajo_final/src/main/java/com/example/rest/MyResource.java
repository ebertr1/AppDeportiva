package com.example.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.controller.dao.services.ReglamentoService;
import com.example.models.enumerador.Formato;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        Map<String, Object> mapa = new HashMap<>();
        ReglamentoService pd = new ReglamentoService(); 
        String aux = "";
        
        try {
            // Verificamos si la lista de reglamentos está vacía
            aux = "La lista de Reglamentos está vacía: " + pd.listAll().isEmpty();

            // Crear y asignar datos al reglamento
            pd.getReglamento().setNombreReglamento("Pepes");
            pd.getReglamento().setDescripcion("Reglamento de Pepes");
            
            // Asignar uno de los valores del enum Formato, por ejemplo, "ELIMINACION"
            pd.getReglamento().setFormato(Formato.ELIMINACION);

            // Guardar el reglamento
            pd.save();

        } catch (Exception e) {
            System.out.println("Error al procesar: " + e.getMessage());
            mapa.put("msg", "Error");
            mapa.put("error", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(mapa).build();
        }

        // Agregar la información al mapa de respuesta
        mapa.put("msg", "Ok");
        mapa.put("data", "Test: " + aux);

        // Construir y devolver la respuesta
        return Response.ok(mapa).build();
    }
}
