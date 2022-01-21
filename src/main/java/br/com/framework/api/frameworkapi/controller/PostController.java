package br.com.framework.api.frameworkapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.framework.api.frameworkapi.dto.PostDto;
import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.repository.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping
	public List<PostDto> getPosts() {
		List<Post> posts = postRepository.findAll();
			return PostDto.converter(posts);
	}

}
