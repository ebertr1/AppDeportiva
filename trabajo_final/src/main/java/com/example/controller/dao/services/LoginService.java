package com.example.controller.dao.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import com.example.controller.dao.UsuarioDao;
import com.example.models.Usuario;

public class LoginService {

	private UsuarioDao userDAO;
	private static final String SECRET_KEY = "miClaveSecreta"; // Esto debe ser más seguro en un entorno real

	public LoginService(UsuarioDao userDAO) {
		this.userDAO = userDAO;
	}

	public String login(String email, String password) {
		Usuario user = userDAO.getUsuariobyEmail(email); // debo de 

		if (user == null) {
			return "Usuario no encontrado";
		}

		// Verificar la contraseña hasheada
		if (BCrypt.checkpw(password, user.getContrasenia())) {
			// Si las credenciales son correctas, generar el JWT
			return generateJWT(user);
		} else {
			return "Contraseña incorrecta";
		}
	}

	private String generateJWT(Usuario user) {
		// Obtener la fecha y hora actual
		long now = System.currentTimeMillis();
		Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		// Generar el JWT con información sobre el usuario
		return Jwts.builder().setSubject(String.valueOf(user.getId())) // ID del usuario como "subject" (sujeto)
				.setIssuedAt(new Date(now)) // Fecha de emisión
				.setExpiration(new Date(now + 3600000)) // El token expira en 1 hora
				.signWith(key, SignatureAlgorithm.HS256) // Firma del JWT con la clave secreta
				.compact();
	}

}
