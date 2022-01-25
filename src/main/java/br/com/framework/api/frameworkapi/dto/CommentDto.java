package br.com.framework.api.frameworkapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.framework.api.frameworkapi.model.Comment;

public class CommentDto {

	private Long id;
	private String comment;
	private LocalDateTime date = LocalDateTime.now();

	public CommentDto() {

	}

	public CommentDto(Comment comment) {
		this.id = comment.getId();
		this.comment = comment.getComment();
		this.date = comment.getDate();
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

	public static List<CommentDto> convert(List<Comment> comments) {
		return comments.stream().map(CommentDto::new).collect(Collectors.toList());
	}

}
