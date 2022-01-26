package br.com.framework.api.frameworkapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import br.com.framework.api.frameworkapi.model.User;
import br.com.framework.api.frameworkapi.repository.ImageRepository;
import br.com.framework.api.frameworkapi.repository.LinkRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;
import br.com.framework.api.frameworkapi.repository.StatusRepository;
import br.com.framework.api.frameworkapi.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	LinkRepository linkRepository;

	@GetMapping
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		return PostDto.converter(posts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailsPostDto> detailerPosts(@PathVariable Long id) {
		Optional<Post> post = postRepository.findById(id);
		if (post.isPresent()) {
			return ResponseEntity.ok(new DetailsPostDto(post.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostForm dados, UriComponentsBuilder uriBuilder) {
		Post post = dados.convert(postRepository, statusRepository, imageRepository);

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> user = userRepository.findByUsername(username);
		post.setUser(user.get());

		postRepository.save(post);

		URI uri = uriBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();

		// this method encapsulates the implementation do insert new image
		dados.newImage(imageRepository, post);

		// this method encapsulates the implementation do insert new link
		dados.newLink(linkRepository, post);

		return ResponseEntity.created(uri).body(new PostDto(post));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removePost(@PathVariable Long id) {
		Optional<Post> optional = postRepository.findById(id);

		if (optional.isPresent()) {

			// get the current user
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Optional<User> user = userRepository.findByUsername(username);
			Long currentUser = user.get().getId();

			// Checking the owner of the post
			Long owner = postRepository.findByUser(id);

			System.out.println("usuario do comment: " + owner);

			if (currentUser == owner) {
				postRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}

		}
		return ResponseEntity.notFound().build();
	}

}
