package br.com.framework.api.frameworkapi.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.framework.api.frameworkapi.model.Image;
import br.com.framework.api.frameworkapi.repository.ImageRepository;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ImagePostForm {

	private String urlImage;
	
	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Image convert(ImageRepository imageRepository) {
		return new Image(urlImage);
	}

}
