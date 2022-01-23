package br.com.framework.api.frameworkapi.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.model.StatusPost;
import br.com.framework.api.frameworkapi.model.User;

public class DetailsPostDto {

	private Long id;
	private String text;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime date;
	private StatusPost status;
	private User user;
	private List<CommentDto> comments;
	private List<ImageDto> images;

	public DetailsPostDto(Post post) {
		this.id = post.getId();
		this.text = post.getText();
		this.date = post.getDate();
		this.status = post.getStatus();
		this.user = post.getUser();
		this.comments = new ArrayList<>();
		this.comments.addAll(post.getComments().stream().map(CommentDto::new).collect(Collectors.toList()));
		this.images = new ArrayList<>();
		this.images.addAll(post.getImages().stream().map(ImageDto::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public StatusPost getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public List<ImageDto> getImages() {
		return images;
	}

}
