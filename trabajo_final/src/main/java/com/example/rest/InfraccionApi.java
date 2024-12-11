package com.example.rest;

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

import com.example.controller.services.InfraccionServices;
import com.example.models.enumerador.ColorTarjeta;
import com.google.gson.Gson;

@Path("infraccion")
public class InfraccionApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInfracciones() {
        HashMap<String, Object> map = new HashMap<>();
        InfraccionServices is = new InfraccionServices();
        map.put("msg", "Ok");
        map.put("data", is.listAll().toArray());
        if (is.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfraccion(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        InfraccionServices is = new InfraccionServices();
        try {
            is.setInfraccion(is.get(id));
        } catch (Exception e) {
            // Handle exception
        }

        map.put("msg", "Ok");
        map.put("data", is.getInfraccion());

        if (is.getInfraccion() == null || is.getInfraccion().getId() == 0) {
            map.put("msg", "No se encontró infracción con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        if (is.listAll().isEmpty()) {
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
            InfraccionServices is = new InfraccionServices();
            is.getInfraccion().setNumTarjeta(Integer.parseInt(map.get("numTarjeta").toString()));
            is.getInfraccion().setIdentificacionJugador(map.get("identificacionJugador").toString());
            is.getInfraccion().setColorTarjeta(ColorTarjeta.valueOf(map.get("colorTarjeta").toString()));
            is.save();
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
            InfraccionServices is = new InfraccionServices();
            is.setInfraccion(is.get(Integer.parseInt(map.get("idInfraccion").toString())));
            is.getInfraccion().setNumTarjeta(Integer.parseInt(map.get("numTarjeta").toString()));
            is.getInfraccion().setIdentificacionJugador(map.get("identificacionJugador").toString());
            is.getInfraccion().setColorTarjeta(ColorTarjeta.valueOf(map.get("colorTarjeta").toString()));
            is.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();

        } catch (Exception e) {
            System.out.println("Error en update| data" + e.toString());
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
            InfraccionServices is = new InfraccionServices();
            Integer id = Integer.parseInt(map.get("idInfraccion").toString());

            Boolean success = is.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Infracción no encontrada");
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