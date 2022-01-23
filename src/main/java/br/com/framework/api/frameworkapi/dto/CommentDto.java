package br.com.framework.api.frameworkapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.framework.api.frameworkapi.model.Comment;
import br.com.framework.api.frameworkapi.model.User;

public class CommentDto {

	private Long id;
	private String comment;
	private LocalDateTime date = LocalDateTime.now();
	private User user;

	public CommentDto() {

	}

	public CommentDto(Comment comment) {
		this.id = comment.getId();
		this.comment = comment.getComment();
		this.date = comment.getDate();
		this.user = comment.getUser();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static List<CommentDto> convert(List<Comment> comments) {
		return comments.stream().map(CommentDto::new).collect(Collectors.toList());
	}

}
