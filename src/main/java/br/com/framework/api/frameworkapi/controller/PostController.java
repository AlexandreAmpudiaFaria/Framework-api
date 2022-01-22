package br.com.framework.api.frameworkapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework.api.frameworkapi.dto.DetailsPostDto;
import br.com.framework.api.frameworkapi.dto.PostDto;
import br.com.framework.api.frameworkapi.form.PostForm;
import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.repository.PostRepository;
import br.com.framework.api.frameworkapi.repository.StatusRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	StatusRepository statusRepository;

	@GetMapping
	public List<PostDto> getPosts() {
		List<Post> posts = postRepository.findAll();
		return PostDto.converter(posts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailsPostDto> detailer(@PathVariable Long id) {
		System.out.println(id);
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			return ResponseEntity.ok(new DetailsPostDto(post.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostForm dados, UriComponentsBuilder uriBuilder) {
		Post post = dados.convert(postRepository, statusRepository);
		postRepository.save(post);

		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).body(new PostDto(post));
	}

}
