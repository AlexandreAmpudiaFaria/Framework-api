package br.com.framework.api.frameworkapi.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.model.StatusPost;

public class DetailsPostDto {

	private Long id;
	private String text;
	private String name;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime date;
	private StatusPost status;
	private List<CommentDto> comments;
	private List<ImageDto> images;
	private List<LinkDto> links;
	private Long user;

	public DetailsPostDto(Post post) {
		this.id = post.getId();
		this.text = post.getText();
		this.name = post.getName();
		this.date = post.getDate();
		this.status = post.getStatus();
		this.comments = new ArrayList<>();
		this.comments.addAll(post.getComments().stream().map(CommentDto::new).collect(Collectors.toList()));
		this.images = new ArrayList<>();
		this.images.addAll(post.getImages().stream().map(ImageDto::new).collect(Collectors.toList()));
		this.links = new ArrayList<>();
		this.links.addAll(post.getLinks().stream().map(LinkDto::new).collect(Collectors.toList()));
		this.user = post.getUser().getId();

	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public StatusPost getStatus() {
		return status;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public List<ImageDto> getImages() {
		return images;
	}

	public List<LinkDto> getLinks() {
		return links;
	}

	public Long getUser() {
		return user;
	}

}
