package br.com.framework.api.frameworkapi.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.framework.api.frameworkapi.model.Link;
import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.repository.LinkRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LinkForm {

	private String url;
	private Long id;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Link convert(LinkRepository linkRepository, PostRepository postRepository) {
		Post post = postRepository.getById(id);
		return new Link(url, post);
	}

}
