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

import br.com.framework.api.frameworkapi.dto.CommentDto;
import br.com.framework.api.frameworkapi.form.CommentsPostForm;
import br.com.framework.api.frameworkapi.model.Comment;
import br.com.framework.api.frameworkapi.model.User;
import br.com.framework.api.frameworkapi.repository.CommentRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;
import br.com.framework.api.frameworkapi.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<CommentDto> getAllComments() {
		List<Comment> comments = commentRepository.findAll();
		return CommentDto.convert(comments);
	}

	@PostMapping
	public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentsPostForm values,
			UriComponentsBuilder uriBuilder) {
		Comment comments = values.convert(commentRepository, postRepository);

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<User> user = userRepository.findByUsername(username);
		comments.setUser(user.get());

		commentRepository.save(comments);

		URI uri = uriBuilder.path("/comments/{id}").buildAndExpand(comments.getId()).toUri();
		return ResponseEntity.created(uri).body(new CommentDto(comments));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removeComment(@PathVariable Long id) {
		Optional<Comment> optional = commentRepository.findById(id);

		System.out.println("id do comment: " + id);

		if (optional.isPresent()) {

			// get the current user
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Optional<User> user = userRepository.findByUsername(username);
			Long currentUser = user.get().getId();
			
			System.out.println("usuario atual: " + currentUser);

			// Checking the owner of the comment
			Long owner = commentRepository.findByUser(id);
			
			System.out.println("usuario do comment: " + owner);

			if (currentUser == owner) {
				commentRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}

		}
		return ResponseEntity.notFound().build();
	}

}
