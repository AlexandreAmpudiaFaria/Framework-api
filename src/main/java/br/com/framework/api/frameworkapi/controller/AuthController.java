package br.com.framework.api.frameworkapi.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.framework.api.frameworkapi.form.AuthForm;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/auth")
public class AuthController {
	
	@PostMapping
	public ResponseEntity<?> authetic(@RequestBody @Valid AuthForm form){
		System.out.println("usuario: " + form.getUsername());
		System.out.println("senha: " + form.getPwd());
		return ResponseEntity.ok().build();
	}

}
