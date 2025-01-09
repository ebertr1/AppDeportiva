package com.example.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.controller.dao.services.LoginService;
import com.example.controller.dao.services.PersonaService;
import com.example.controller.dao.services.UsuarioService;
import com.example.models.Persona;

@Path("/login")
public class LoginApi {
	
	@Path("/auth")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(HashMap requ) throws Exception{
		//1. Llamo los servicios
		LoginService logService = new LoginService();
		// Servicio para acceder al id Persona
		UsuarioService userService = new UsuarioService();
		// Servicio para traer el objeto persona por ID
		PersonaService personaService = new PersonaService();
		
		Persona persona;
		
		String mensaje;
		
		//2 Construir response 
		HashMap map = new HashMap<>();
		
		String email = requ.get("correo").toString();
		try {			
			String pwd = requ.get("contrasenia").toString();
			
			System.out.println("email: "+email+", pwd: "+pwd);
			
			mensaje = logService.login(email, pwd);
			
		} catch (Exception e) {
			// TODO: handle exception
			mensaje = "Ocurrio un error "+e.getCause();
			map.put("error Localized", e.getLocalizedMessage());
			map.put("error Mesag", e.getMessage());
		}
		
		if(mensaje.compareToIgnoreCase("Usuario no existe") == 0 || 
				mensaje.compareToIgnoreCase("Contraseña incorrecta") == 0) {
			map.put("msg", "Error, credenciales incorrectas o el usuario no existe..");
			return Response.status(Status.UNAUTHORIZED).entity(map).build();
		}else {			
			map.put("msg", "OK");
			// Se debe de construir un Response Builder
			map.put("data_tokn", mensaje);
			persona = personaService.get(userService.findUserbyEmail(email).getIdPersona());
			map.put("persona", persona.getApellido()+" "+persona.getNombre());
			return Response.status(Status.OK).entity(map).build();
		}
				
//		return Response.ok(map).build();
		
		
	}
}
