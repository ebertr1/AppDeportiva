package com.example.controller.dao.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.example.controller.dao.UsuarioDao;
import com.example.models.Administrador;
import com.example.models.Usuario;

public class LoginService {

//	private UsuarioDao userDAO;
	private UsuarioService userService;
	
	private static final String SECRET_KEY = "asdjoijqwijIASJOJDAJoijwiejqeojasjdoqpomzxcmllAasd"; // Esto debe ser más seguro en un entorno real

	public LoginService() {
		this.userService = new UsuarioService();
	}

	public String login(String email, String password) throws Exception {
		Usuario user = userService.findUserbyEmail(email); // debo de 

		if (user == null) {
			return "Usuario no existe";
		}
		
		
		// Verificar la contraseña hasheada
		if (BCrypt.checkpw(password, user.getContrasenia())) {
			// Si las credenciales son correctas, generar el JWT
			return generateJWT(user);
		} else {
			return "Contraseña incorrecta";
		}
	}

	private String generateJWT(Usuario user) throws Exception {
		// Obtener la fecha y hora actual
		long now = System.currentTimeMillis();
		Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		Map claims = new HashMap<>();
		
		// construimos un map
		claims.put("email", user.getCorreo());
		Administrador personaAdmin = userService.findPersonabyEmail(user.getCorreo());
		claims.put("nombres completos", personaAdmin.getNombre()+" "+personaAdmin.getApellido());
		claims.put("rol", user.getRole().getNombre());
		
		// Generar el JWT con información sobre el usuario
		return Jwts.builder().setSubject(String.valueOf(user.getId())) // ID del usuario como "subject" (sujeto)
				.setClaims(claims)
				.setIssuedAt(new Date(now)) // Fecha de emisión
				.setExpiration(new Date(now + 3600000)) // El token expira en 1 hora (3600000 segundos)
				.signWith(key, SignatureAlgorithm.HS256) // Firma del JWT con la clave secreta
				.compact();
	}
	
	// metodo para refrescar el token
	
	// Metodo para logout

}
