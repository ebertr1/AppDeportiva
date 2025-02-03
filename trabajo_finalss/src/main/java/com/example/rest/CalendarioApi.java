package com.example.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controller.dao.services.CalendarioService;
import com.example.controller.dao.services.JugadorEquipoServices;
import com.example.controller.dao.services.JugadorServices;
import com.example.controller.dao.services.PersonaService;
import com.example.models.Calendario;
import com.example.models.enumerador.Formato;
import com.example.models.enumerador.Genero;
import com.example.models.enumerador.TipoIdentificacion;
import com.google.gson.Gson;

@Path("calendario")
public class CalendarioApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        HashMap map = new HashMap<>();
        CalendarioService js = new CalendarioService();
        map.put("msg", "Ok");
        map.put("data", js.listAll().toArray());
        if (js.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        CalendarioService js = new CalendarioService();
        try {
            js.setCalendario(js.get(id));
        } catch (Exception e) {

        }

        map.put("msg", "Ok");
        map.put("data", js.getCalendario());

        if (js.listAll().isEmpty()) {
            map.put("data", new Object[] {});
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }
        return Response.ok(map).build();
    }

   

    @Path("/listType")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getType() {
        HashMap map = new HashMap<>();
        CalendarioService js = new CalendarioService();
        map.put("msg", "Ok");
        map.put("data", js.getCalendario());
        if (js.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    
    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            // Validar que los campos requeridos están presentes
            if (map.get("fechaJornada") == null || map.get("nroEncuentros") == null) {
                res.put("msg", "Error");
                res.put("data", "Campos requeridos faltantes: 'fechaJornada' o 'nroEncuentros'");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Validar el formato de fecha como String
            String fechaJornada = map.get("fechaJornada").toString();
            if (!fechaJornada.matches("\\d{4}-\\d{2}-\\d{2}")) {
                res.put("msg", "Error");
                res.put("data", "Formato de fecha inválido. Se esperaba 'yyyy-MM-dd'.");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Validar que 'nroEncuentros' sea un número entero válido
            int nroEncuentros;
            try {
                nroEncuentros = Integer.parseInt(map.get("nroEncuentros").toString());
                if (nroEncuentros <= 0) {
                    res.put("msg", "Error");
                    res.put("data", "'nroEncuentros' debe ser un número positivo.");
                    return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
                }
            } catch (NumberFormatException e) {
                res.put("msg", "Error");
                res.put("data", "'nroEncuentros' debe ser un número entero válido.");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Crear y guardar el objeto Calendario
            CalendarioService ps = new CalendarioService();
            ps.getCalendario().setFechaJornada(fechaJornada);
            ps.getCalendario().setNroEncuentros(nroEncuentros);
    
            ps.save();
    
            // Respuesta de éxito
            res.put("msg", "Ok");
            res.put("data", "Calendario guardado correctamente.");
            return Response.ok(res).build();
    
        } catch (Exception e) {
            // Manejo de errores generales
            System.out.println("Error en save data: " + e.toString());
            res.put("msg", "Error");
            res.put("data", "Error inesperado: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
    
    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            // Validar que los campos requeridos están presentes
            if (map.get("idCalendario") == null || map.get("fechaJornada") == null || map.get("nroEncuentros") == null) {
                res.put("msg", "Error");
                res.put("data", "Campos requeridos faltantes: 'idCalendario', 'fechaJornada' o 'nroEncuentros'");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Validar que 'idCalendario' sea un número entero válido
            int idCalendario;
            try {
                idCalendario = Integer.parseInt(map.get("idCalendario").toString());
            } catch (NumberFormatException e) {
                res.put("msg", "Error");
                res.put("data", "'idCalendario' debe ser un número entero válido.");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Validar el formato de fecha como String
            String fechaJornada = map.get("fechaJornada").toString();
            if (!fechaJornada.matches("\\d{4}-\\d{2}-\\d{2}")) {
                res.put("msg", "Error");
                res.put("data", "Formato de fecha inválido. Se esperaba 'yyyy-MM-dd'.");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Validar que 'nroEncuentros' sea un número entero válido
            int nroEncuentros;
            try {
                nroEncuentros = Integer.parseInt(map.get("nroEncuentros").toString());
                if (nroEncuentros <= 0) {
                    res.put("msg", "Error");
                    res.put("data", "'nroEncuentros' debe ser un número positivo.");
                    return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
                }
            } catch (NumberFormatException e) {
                res.put("msg", "Error");
                res.put("data", "'nroEncuentros' debe ser un número entero válido.");
                return Response.status(Response.Status.BAD_REQUEST).entity(res).build();
            }
    
            // Actualizar el objeto Calendario
            CalendarioService jes = new CalendarioService();
            Calendario calendario = jes.get(idCalendario);
    
            if (calendario == null) {
                res.put("msg", "Error");
                res.put("data", "Calendario con ID " + idCalendario + " no encontrado.");
                return Response.status(Response.Status.NOT_FOUND).entity(res).build();
            }
    
            calendario.setFechaJornada(fechaJornada);
            calendario.setNroEncuentros(nroEncuentros);
    
            // Guardar los cambios
            jes.setCalendario(calendario);
            jes.update();
    
            // Respuesta de éxito
            res.put("msg", "Ok");
            res.put("data", "Calendario actualizado correctamente.");
            return Response.ok(res).build();
    
        } catch (Exception e) {
            System.out.println("Error en update data: " + e.toString());
            res.put("msg", "Error");
            res.put("data", "Error inesperado: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
    

    @Path("/delete/{id}")
@DELETE  // Cambié el método a DELETE
@Produces(MediaType.APPLICATION_JSON)
public Response delete(@PathParam("id") Integer id) {
    HashMap<String, Object> res = new HashMap<>();

    try {
        CalendarioService js = new CalendarioService();

        // Llamamos al servicio para eliminar la inscripción con el id proporcionado
        Boolean success = js.delete(id);

        if (success) {
            res.put("msg", "Ok");
            res.put("data", "Eliminado correctamente");
            return Response.ok(res).build();
        } else {
            res.put("msg", "Error");
            res.put("data", "Inscripción no encontrada");
            return Response.status(Status.NOT_FOUND).entity(res).build();
        }
    } catch (Exception e) {
        System.out.println("Error en delete data: " + e.toString());
        res.put("msg", "Error");
        res.put("data", e.toString());
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
    }
}

}
