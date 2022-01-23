package br.com.framework.api.frameworkapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework.api.frameworkapi.dto.LinkDto;
import br.com.framework.api.frameworkapi.form.LinkForm;
import br.com.framework.api.frameworkapi.model.Link;
import br.com.framework.api.frameworkapi.repository.LinkRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/links")
public class LinkController {

	@Autowired
	LinkRepository linkRepository;

	@Autowired
	PostRepository postRepository;
	
	@GetMapping
	public List<LinkDto> getAllImages() {
		List<Link> links = linkRepository.findAll();
		return LinkDto.convert(links);
	}

	@PostMapping
	public ResponseEntity<LinkDto> saveLink(@RequestBody @Valid LinkForm values, UriComponentsBuilder uriBuilder) {
		Link links = values.convert(linkRepository, postRepository);
		linkRepository.save(links);

		URI uri = uriBuilder.path("/links/{id}").buildAndExpand(links.getId()).toUri();
		return ResponseEntity.created(uri).body(new LinkDto(links));
	}

}
