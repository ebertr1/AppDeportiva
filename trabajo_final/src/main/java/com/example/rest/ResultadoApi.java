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

import com.example.controller.services.ResultadoServices;
import com.google.gson.Gson;

@Path("resultado")
public class ResultadoApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResultados() {
        HashMap<String, Object> map = new HashMap<>();
        ResultadoServices rs = new ResultadoServices();
        map.put("msg", "Ok");
        map.put("data", rs.listAll().toArray());
        if (rs.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultado(@PathParam("id") Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        ResultadoServices rs = new ResultadoServices();
        try {
            rs.setResultado(rs.get(id));
        } catch (Exception e) {
            // Handle exception
        }

        map.put("msg", "Ok");
        map.put("data", rs.getResultado());

        if (rs.getResultado() == null || rs.getResultado().getId() == 0) {
            map.put("msg", "No se encontró resultado con ese identificador");
            return Response.status(Status.NOT_FOUND).entity(map).build();
        }

        if (rs.listAll().isEmpty()) {
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
            ResultadoServices rs = new ResultadoServices();
            rs.getResultado().setEquipoGanador(map.get("equipoGanador").toString());
            rs.getResultado().setEquipoPerdedor(map.get("equipoPerdedor").toString());
            rs.getResultado().setGolesEquipo1(Integer.parseInt(map.get("golesEquipo1").toString()));
            rs.getResultado().setGolesEquipo2(Integer.parseInt(map.get("golesEquipo2").toString()));
            rs.getResultado().setEmpate(Boolean.parseBoolean(map.get("empate").toString()));
            rs.getResultado().setPuntosEncuentro(Integer.parseInt(map.get("puntosEncuentro").toString()));
            rs.save();
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
            ResultadoServices rs = new ResultadoServices();
            rs.setResultado(rs.get(Integer.parseInt(map.get("idResultado").toString())));
            rs.getResultado().setEquipoGanador(map.get("equipoGanador").toString());
            rs.getResultado().setEquipoPerdedor(map.get("equipoPerdedor").toString());
            rs.getResultado().setGolesEquipo1(Integer.parseInt(map.get("golesEquipo1").toString()));
            rs.getResultado().setGolesEquipo2(Integer.parseInt(map.get("golesEquipo2").toString()));
            rs.getResultado().setEmpate(Boolean.parseBoolean(map.get("empate").toString()));
            rs.getResultado().setPuntosEncuentro(Integer.parseInt(map.get("puntosEncuentro").toString()));
            rs.update();
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
            ResultadoServices rs = new ResultadoServices();
            Integer id = Integer.parseInt(map.get("idResultado").toString());

            Boolean success = rs.delete(id);
            if (success) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "Resultado no encontrado");
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