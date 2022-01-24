package br.com.framework.api.frameworkapi.form;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.framework.api.frameworkapi.model.Image;
import br.com.framework.api.frameworkapi.model.Link;
import br.com.framework.api.frameworkapi.model.Post;
import br.com.framework.api.frameworkapi.model.StatusPost;
import br.com.framework.api.frameworkapi.repository.ImageRepository;
import br.com.framework.api.frameworkapi.repository.LinkRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;
import br.com.framework.api.frameworkapi.repository.StatusRepository;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PostForm {

	private String text;
	private Integer status;
	private List<Image> images = new ArrayList<>();
	private List<Link> links = new ArrayList<>();

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

	public List<Image> getImage() {
		return images;
	}

	public void setImage(List<Image> images) {
		this.images = images;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Post convert(PostRepository postRepository, StatusRepository statusRepository,
			ImageRepository imageRepository) {

		StatusPost statusPost = statusRepository.getById(status);
		return new Post(text, statusPost);
	}

	public void newImage(ImageRepository imageRepository, Post post) {
		for (Image image : images) {
			Image result = new Image();
			System.out.println("to passando aqui no segundo metodo");
			result.setUrl(image.getUrl());
			result.setPost(post);
			result.setPhotoAlbum(null);
			imageRepository.save(result);
		}
	}

	public void newLink(LinkRepository linkRepository, Post post) {
		for (Link links : links) {
			Link result = new Link();
			result.setUrl(links.getUrl());
			result.setPost(post);
			linkRepository.save(result);
		}

	}

}
