package br.com.framework.api.frameworkapi.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.framework.api.frameworkapi.model.PhotoAlbum;

public class PhotoAlbumDto {

	private Long id;
	private String name;
	private String description;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dateCreate;
	private Long user;

	private List<ImageDto> images = new ArrayList<>();

	public PhotoAlbumDto() {

	}

	public PhotoAlbumDto(PhotoAlbum photoAlbum) {
		this.id = photoAlbum.getId();
		this.name = photoAlbum.getName();
		this.description = photoAlbum.getDescription();
		this.dateCreate = photoAlbum.getDateCreate();
		this.images = new ArrayList<>();
		this.images.addAll(photoAlbum.getImages().stream().map(ImageDto::new).collect(Collectors.toList()));
		this.user = photoAlbum.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getDateCreate() {
		return dateCreate;
	}

	public Long getUser() {
		return user;
	}

	public List<ImageDto> getImages() {
		return images;
	}

	public static List<PhotoAlbumDto> converter(List<PhotoAlbum> album) {
		return album.stream().map(PhotoAlbumDto::new).collect(Collectors.toList());
	}

}
