package br.com.framework.api.frameworkapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.framework.api.frameworkapi.dto.TokenDto;
import br.com.framework.api.frameworkapi.form.AuthForm;
import br.com.framework.api.frameworkapi.security.TokenService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> authetic(@RequestBody @Valid AuthForm form){
		UsernamePasswordAuthenticationToken data = form.convert();
		
		try {
			Authentication authentication = authManager.authenticate(data);
			String token = tokenService.generateToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (org.springframework.security.core.AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
