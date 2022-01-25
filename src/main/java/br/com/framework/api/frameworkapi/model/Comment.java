package br.com.framework.api.frameworkapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends Status implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String comment;
	private LocalDateTime date = LocalDateTime.now();

	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private Post post;*/
	
	@ManyToOne
	private Post post;

	public Comment() {

	}

	public Comment(String comment, Post post) {
		this.comment = comment;
		this.post = post;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	

}
