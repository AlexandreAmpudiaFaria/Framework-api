package br.com.framework.api.frameworkapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/links")
public class LinkController {

	/*@Autowired
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
	}*/

}
