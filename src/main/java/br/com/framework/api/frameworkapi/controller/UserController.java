package br.com.framework.api.frameworkapi.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework.api.frameworkapi.dto.UserDto;
import br.com.framework.api.frameworkapi.form.NewUserForm;
import br.com.framework.api.frameworkapi.model.User;
import br.com.framework.api.frameworkapi.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid NewUserForm values,
			UriComponentsBuilder uriBuilder) {
		User user = values.convert(userRepository);
		userRepository.save(user);

		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}

}
