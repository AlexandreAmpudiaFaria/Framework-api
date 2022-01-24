package br.com.framework.api.frameworkapi.form;

import java.util.ArrayList;
import java.util.List;

import br.com.framework.api.frameworkapi.model.Image;
import br.com.framework.api.frameworkapi.model.PhotoAlbum;
import br.com.framework.api.frameworkapi.repository.ImageRepository;
import br.com.framework.api.frameworkapi.repository.PhotoAlbumRepository;

public class PhotoAlbumForm {

	private String name;
	private String description;
	private List<Image> images = new ArrayList<>();

	// private User user;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public PhotoAlbum convert(PhotoAlbumRepository photoAlbumRepository) {
		return new PhotoAlbum(name, description);
	}

	public void newImage(ImageRepository imageRepository, PhotoAlbum album) {
		for (Image image : images) {
			Image result = new Image();
			System.out.println("to passando aqui no segundo metodo");
			result.setUrl(image.getUrl());
			result.setPost(null);
			result.setPhotoAlbum(album);
			imageRepository.save(result);
		}
		
	}

}
