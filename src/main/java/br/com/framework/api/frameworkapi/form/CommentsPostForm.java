package br.com.framework.api.frameworkapi.form;

import br.com.framework.api.frameworkapi.model.Comment;
import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.repository.CommentRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;

//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CommentsPostForm {

	private String txtComment;
	private Long id;

	public String getComment() {
		return txtComment;
	}

	public void setComment(String txtComment) {
		this.txtComment = txtComment;
	}

	public Long getPost() {
		return id;
	}

	public void setPost(Long id) {
		this.id = id;
	}

	public Comment convert(CommentRepository commentRepository, PostRepository postRepository) {
		System.out.println("aqui o id " + id);
		Post post = postRepository.getById(id);
		return new Comment(txtComment, post);
	}


}
