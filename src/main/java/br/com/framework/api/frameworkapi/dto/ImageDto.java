package br.com.framework.api.frameworkapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.framework.api.frameworkapi.model.Image;

public class ImageDto {

	private Long id;
	private String url;

	public ImageDto() {

	}

	public ImageDto(Image images) {
		this.id = images.getId();
		this.url = images.getUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static List<ImageDto> convert(List<Image> images) {
		return images.stream().map(ImageDto::new).collect(Collectors.toList());
	}

}
