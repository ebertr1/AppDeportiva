package com.example.rest;
<<<<<<< HEAD

import java.text.SimpleDateFormat;
=======
import java.util.Date;
>>>>>>> origin/rama_Isauro
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

import com.example.controller.dao.services.CampeonatoServices;
import com.google.gson.Gson;

@Path("campeonato") 
public class CampeonatoApi {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        HashMap map = new HashMap<>();
        CampeonatoServices cs = new CampeonatoServices();
        map.put("msg", "Ok");
        map.put("data", cs.listAll().toArray());

        if (cs.listAll().isEmpty()) {
            map.put("msg",new Object[]{});        }
        return Response.ok(map).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") Integer id) {
        HashMap map = new HashMap<>();
        CampeonatoServices cs = new CampeonatoServices();
        try {
            cs.setCampeonato(cs.get(id));
        } catch (Exception e) {

        }

        map.put("msg", "Ok");
        map.put("data", cs.getCampeonato());

        if (cs.getCampeonato() == null || cs.getCampeonato().getId() == 0) {
            map.put("msg", "No se encontró campeonato con ese identificador");
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
    public Response save(HashMap map) {
        HashMap res = new HashMap<>();
        Gson g = new Gson();
        String a= g.toJson(map);
        System.out.println("****"+a);
        try {
            CampeonatoServices cs = new CampeonatoServices();
            //cs.getCampeonato().setId(0);
            cs.getCampeonato().setNombre(map.get("nombre").toString());
<<<<<<< HEAD
            cs.getCampeonato().setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("fechaInicio").toString())); 
            cs.getCampeonato().setFechaFin(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("fechaFin").toString()));   
            cs.getCampeonato().setTipoCategoria(cs.getTipoCategoria(map.get("Categoria").toString()));   
=======
            cs.getCampeonato().setFechaInicio(new Date());
            cs.getCampeonato().setFechaFin(new Date());
            cs.getCampeonato().setCategoria(cs.getTipoCategoria(map.get("Categoria").toString()));   
>>>>>>> origin/rama_Isauro
            cs.save();

            res.put("msg", "ok");
            res.put("msg", "Campeonato guardado");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error savee data" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(map).build();
        }
    }

    @Path("/listType")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTypeCategoria(){
        HashMap map = new HashMap<>();
        CampeonatoServices cs = new CampeonatoServices();
        map.put("msg", "Ok");
        map.put("data", cs.getTipos());
        if (cs.listAll().isEmpty()) {
            map.put("data", new Object[] {});
        }
        return Response.ok(map).build();

    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap map){
        HashMap res = new HashMap<>();
        try {
            CampeonatoServices cs = new CampeonatoServices();
<<<<<<< HEAD
            cs.getCampeonato().setId(Integer.parseInt(map.get("id").toString()));
            cs.getCampeonato().setNombre(map.get("nombre").toString());
            cs.getCampeonato().setFechaInicio(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("fechaInicio").toString()));
            cs.getCampeonato().setFechaFin(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("fechaFin").toString()));
            cs.getCampeonato().setTipoCategoria(cs.getTipoCategoria(map.get("Categoria").toString()));
=======
            cs.setCampeonato(cs.get(Integer.parseInt(map.get("isCampeonato").toString())));
            cs.getCampeonato().setNombre(map.get("nombre").toString());
            cs.getCampeonato().setFechaInicio(new Date());
            cs.getCampeonato().setFechaFin(new Date());
            cs.getCampeonato().setCategoria(cs.getTipoCategoria(map.get("Categoria").toString()));
>>>>>>> origin/rama_Isauro
            cs.update();
            res.put("msg", "Ok");
            res.put("data", "Actualizado correctamente");
            return Response.ok(res).build();
        } catch (Exception e) {
            System.out.println("Error update data" + e.toString());
            res.put("msg", "Error");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }
    }

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(HashMap<String, Object> map){
        HashMap<String, Object> res = new HashMap<>();
        try {
            CampeonatoServices cs = new CampeonatoServices();
            Integer id = Integer.parseInt(map.get("id").toString());

            Boolean result = cs.delete(id);
            if (result) {
                res.put("msg", "Ok");
                res.put("data", "Eliminado correctamente");
                return Response.ok(res).build();
            } else {
                res.put("msg", "Error");
                res.put("data", "No se pudo eliminar");
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
