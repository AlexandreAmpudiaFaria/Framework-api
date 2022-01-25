package br.com.framework.api.frameworkapi.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.framework.api.frameworkapi.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${framework-api.jwt.expiration}")
	private String expiration;
	
	@Value("${framework-api.jwt.secret}")
	private String secret;

	public String generateToken(Authentication authentication) {
		User logged = (User) authentication.getPrincipal();
		Date now = new Date();
		Date dateExpiration = new Date(now.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("Framework API")
				.setSubject(logged.getId().toString())
				.setIssuedAt(now)
				.setExpiration(dateExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
