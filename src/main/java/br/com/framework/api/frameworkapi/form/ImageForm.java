package br.com.framework.api.frameworkapi.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.framework.api.frameworkapi.model.Image;
import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.repository.ImageRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ImageForm {

	private String urlImage;
	private Long id;

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Long getPost() {
		return id;
	}

	public void setPost(Long id) {
		this.id = id;
	}

	public Image convert(ImageRepository imageRepository, PostRepository postRepository) {
		Post post = postRepository.getById(id);
		return new Image(urlImage, post);
	}

}
