package br.com.framework.api.frameworkapi.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.model.StatusPost;
import br.com.framework.api.frameworkapi.repository.PostRepository;
import br.com.framework.api.frameworkapi.repository.StatusRepository;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PostForm {

	private String text;
	private Integer status;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Post convert(PostRepository postRepository, StatusRepository statusRepository) {
		StatusPost statusPost = statusRepository.getById(status);
		return new Post(text, statusPost);
	}

}
