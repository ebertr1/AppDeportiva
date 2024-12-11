package com.example.rest;

import java.sql.Time;
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

import com.example.controller.dao.services.EncuentroServices;
import com.google.gson.Gson;

@Path("encuentro")
public class EncuentroApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEncuentros() {
        HashMap<String, Object> map = new HashMap<>();
        EncuentroServices es = new EncuentroServices();
        map.put("msg", "Ok");
        map.put("data", es.listAll().toArray());
        if (es.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEncuentro(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        EncuentroServices es = new EncuentroServices();
        try {
            es.setEncuentro(es.get(id));
        } catch (Exception e) {
            // Handle exception
        }

        map.put("msg", "Ok");
        map.put("data", es.getEncuentro());

        if (es.getEncuentro() == null || es.getEncuentro().getId() == 0) {
            map.put("msg", "No se encontró encuentro con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        if (es.listAll().isEmpty()) {
            map.put("data", new Object[] {});
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }
        return Response.ok(map).build();
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();
        Gson g = new Gson();
        String a = g.toJson(map);
        System.out.println("***** " + a);

        try {
            EncuentroServices es = new EncuentroServices();
            es.getEncuentro().setIdInscrito1(Integer.parseInt(map.get("idInscrito1").toString()));
            es.getEncuentro().setIdInscrito2(Integer.parseInt(map.get("idInscrito2").toString()));
            es.getEncuentro().setUbicacion(map.get("ubicacion").toString());
            es.getEncuentro().setIdentificacion(map.get("identificacion").toString());
            es.getEncuentro().setEstado(Boolean.parseBoolean(map.get("estado").toString()));
            es.getEncuentro().setHoraInicio(Time.valueOf(map.get("horaInicio").toString()));
            es.save();
            res.put("msg", "Ok");
            res.put("data", "Guardado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            System.out.println("Error en save data" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            EncuentroServices es = new EncuentroServices();
            es.setEncuentro(es.get(Integer.parseInt(map.get("idEncuentro").toString())));
            es.getEncuentro().setIdInscrito1(Integer.parseInt(map.get("idInscrito1").toString()));
            es.getEncuentro().setIdInscrito2(Integer.parseInt(map.get("idInscrito2").toString()));
            es.getEncuentro().setUbicacion(map.get("ubicacion").toString());
            es.getEncuentro().setIdentificacion(map.get("identificacion").toString());
            es.getEncuentro().setEstado(Boolean.parseBoolean(map.get("estado").toString()));
            es.getEncuentro().setHoraInicio(Time.valueOf(map.get("horaInicio").toString()));
            es.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            System.out.println("Error en update data" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap<String, Object> map) {
        HashMap<String, Object> res = new HashMap<>();

        try {
            EncuentroServices es = new EncuentroServices();
            Integer id = Integer.parseInt(map.get("idEncuentro").toString());

            Boolean success = es.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Encuentro no encontrado");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            System.out.println("Error en delete data" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }
}