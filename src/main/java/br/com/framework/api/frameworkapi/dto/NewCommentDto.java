package br.com.framework.api.frameworkapi.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import br.com.framework.api.frameworkapi.model.Comment;
import br.com.framework.api.frameworkapi.model.Post;

public class NewCommentDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String comment;
	private Post post;

	public NewCommentDto() {
		
	}

	public NewCommentDto(Comment comment) {
		this.comment = comment.getComment();
		this.post = comment.getPost();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static List<NewCommentDto> convert(List<Comment> comments) {
		return comments.stream().map(NewCommentDto::new).collect(Collectors.toList());
	}

}
