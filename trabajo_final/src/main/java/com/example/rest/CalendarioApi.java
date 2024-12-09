package com.example.rest;

import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controller.dao.services.CalendarioServices;
import com.google.gson.Gson;

@Path("calendario")
public class CalendarioApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        HashMap map = new HashMap<>();
        CalendarioServices cs = new CalendarioServices();
        map.put("msg", "Ok");
        map.put("data", cs.listAll().toArray());
        if (cs.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        CalendarioServices cs = new CalendarioServices();
        try {
            cs.setCalendario(cs.get(id));
        } catch (Exception e) {

        }

        map.put("msg", "Ok");
        map.put("data", cs.getCalendario());

        if (cs.getCalendario() == null || cs.getCalendario().getId() == 0) {
            map.put("msg", "No se encontró calendario con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        if (cs.listAll().isEmpty()) {
            map.put("data", new Object[] {});
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }
        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response save(HashMap map){
        HashMap res = new HashMap<>();
        Gson g= new Gson();
        String a = g.toJson(map);
        System.out.println("***** " + a);
        try {
            CalendarioServices cs = new CalendarioServices();

            cs.getCalendario().setFechaJornada(new Date());
            cs.getCalendario().setNroEncuentros(Integer.parseInt(map.get("nroEncuentros").toString()));
            cs.getCalendario().setId_Campeonato(Integer.parseInt(map.get("idCampeonato").toString()));
            cs.save();
            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error update data" + e.toString());
            res.put ("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response update(HashMap map){
        HashMap res = new HashMap<>();
        try {
            CalendarioServices cs = new CalendarioServices();
            cs.setCalendario(cs.get(Integer.parseInt(map.get("idCalendario").toString())));
            cs.getCalendario().setFechaJornada(new Date());
            cs.getCalendario().setNroEncuentros(Integer.parseInt(map.get("nroEncuentros").toString()));
            cs.getCalendario().setId_Campeonato(Integer.parseInt(map.get("idCampeonato").toString()));
            cs.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error update data" + e.toString());
            res.put ("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap map){
        HashMap res = new HashMap<>();
        try {
            CalendarioServices cs = new CalendarioServices();
            Integer id = Integer.parseInt(map.get("id").toString());

            Boolean result = cs.delete(id);
            if (result) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            }else{
                res.put("msg", "Error");
                res.put("data", "No se pudo eliminar");
                return Response.status(Status.NOT_FOUND).entity(res).build();

            }

        } catch (Exception e) {
            System.out.println("Error delete data" + e.toString());
            res.put ("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}
