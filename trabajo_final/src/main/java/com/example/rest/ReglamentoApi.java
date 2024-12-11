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

import com.example.controller.dao.services.ReglamentoServices;
import com.google.gson.Gson;    

@Path("reglamento")
public class ReglamentoApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        HashMap map = new HashMap<>();
        ReglamentoServices rs = new ReglamentoServices();
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
    public Response getPerson(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        ReglamentoServices rs = new ReglamentoServices();
        try {
            rs.setReglamento(rs.get(id));
        } catch (Exception e) {

        }

        map.put("msg", "Ok");
        map.put("data", rs.getReglamento());

        if (rs.getReglamento() == null || rs.getReglamento().getId() == 0) {
            map.put("msg", "No se encontró reglamento con ese identificador");
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
    public Response save(HashMap map){
        HashMap res = new HashMap<>();
        Gson g= new Gson();
        String a= g.toJson(map);
        System.out.println("****"+a);   
        try {
            ReglamentoServices rs = new ReglamentoServices();
            rs.getReglamento().setNombreReglamento(map.get("nombreReglamento").toString());
            rs.getReglamento().setDescripcion(map.get("descripcion").toString());
            rs.getReglamento().setTipoFormato(rs.getTipoFormato(map.get("formato").toString()));
            rs.save();
            res.put("msg", "Ok");
            res.put("msg", "Reglamento guardado");
            return Response.ok(res).build();

        } catch (Exception e) {
            System.out.println("Error save data "+e.getMessage());
            res.put("msg", "Error");
            res.put("data",e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }

    }

    @Path("/listTypeFormato")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTypeFormato() {
        HashMap map = new HashMap<>();
        ReglamentoServices rs = new ReglamentoServices();
        map.put("msg", "Ok");
        map.put("data", rs.getFormato());
        if (rs.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap map) {
        HashMap res = new HashMap<>();
        Gson g = new Gson();
        String a = g.toJson(map);
        System.out.println("****" + a);
        try {
            ReglamentoServices rs = new ReglamentoServices();
            rs.getReglamento().setId(Integer.parseInt(map.get("id").toString()));
            rs.getReglamento().setNombreReglamento(map.get("nombreReglamento").toString());
            rs.getReglamento().setDescripcion(map.get("descripcion").toString());
            rs.getReglamento().setTipoFormato(rs.getTipoFormato(map.get("formato").toString()));
            rs.update();
            res.put("msg", "Ok");
            res.put("msg", "Reglamento actualizado");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error save data " + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(map).build();
        }
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap map) {
        HashMap<String, Object> res = new HashMap<>();
        try {
            ReglamentoServices rs = new ReglamentoServices();
            Integer id = Integer.parseInt(map.get("id").toString());
            Boolean result = rs.delete(id);
            if(result){
                res.put("msg", "Ok");
                res.put("msg", "Reglamento eliminado");
                return Response.ok(res).build();
            }else{
                res.put("msg", "Error");
                res.put("msg", "Reglamento no encontrado");
                return Response.status(Status.NOT_FOUND).entity(res).build();
            }
        } catch (Exception e) {
            System.out.println("Error save data " + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(map).build();
        }
    }
}
