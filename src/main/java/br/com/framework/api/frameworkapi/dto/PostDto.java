package br.com.framework.api.frameworkapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.model.StatusPost;
import br.com.framework.api.frameworkapi.model.User;

public class PostDto {

	private Long id;
	private String text;
	private String name;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime date;
	private StatusPost status;
	private User user;

	public PostDto() {
	}

	public PostDto(Post post) {
		this.id = post.getId();
		this.text = post.getText();
		this.date = post.getDate();
		this.status = post.getStatus();
		this.user = post.getUser();
		this.name = post.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public StatusPost getStatus() {
		return status;
	}

	public void setStatus(StatusPost status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<PostDto> converter(List<Post> posts) {
		return posts.stream().map(PostDto::new).collect(Collectors.toList());
	}

}
