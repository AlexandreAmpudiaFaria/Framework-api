package br.com.framework.api.frameworkapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import br.com.framework.api.frameworkapi.repository.CommentRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostRepository postRepository;

	@GetMapping
	@RequestMapping(value = "/{post}/{id}")
	public List<CommentDto> getCommentsByPost(@PathVariable("id") Long id) {
		List<Comment> comments = commentRepository.findByPost(id);
		return CommentDto.convert(comments);
	}
	
	@GetMapping
	public List<CommentDto> getAllComments() {
		List<Comment> comments = commentRepository.findAll();
		return CommentDto.convert(comments);
	}
	
	@PostMapping
	public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentsPostForm values, UriComponentsBuilder uriBuilder) {
		System.out.println(values);
		Comment comments = values.convert(commentRepository, postRepository);
		commentRepository.save(comments);
		
		URI uri = uriBuilder.path("/comments/{id}").buildAndExpand(comments.getId()).toUri();
		return ResponseEntity.created(uri).body(new CommentDto(comments));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Comment> optional = commentRepository.findById(id);
		if (optional.isPresent()) {
			commentRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	/*
	 * @GetMapping public List<CommentDto> getComments(@RequestBody CommentsPostForm
	 * values) { Long result = values.toConvert(commentRepository);
	 * System.out.println(result); List<Comment> comments =
	 * commentRepository.findByPost(result); return CommentDto.convert(comments); }
	 */

}
