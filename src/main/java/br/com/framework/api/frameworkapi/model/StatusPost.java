package br.com.framework.api.frameworkapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StatusPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String statusPost;

	public StatusPost() {
	}

	public StatusPost(Long id, String statusPost) {
		this.id = id;
		this.statusPost = statusPost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusPost() {
		return statusPost;
	}

	public void setStatusPost(String statusPost) {
		this.statusPost = statusPost;
	}

}
