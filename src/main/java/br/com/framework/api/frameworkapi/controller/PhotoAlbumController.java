package br.com.framework.api.frameworkapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework.api.frameworkapi.dto.PhotoAlbumDto;
import br.com.framework.api.frameworkapi.form.PhotoAlbumForm;
import br.com.framework.api.frameworkapi.model.PhotoAlbum;
import br.com.framework.api.frameworkapi.repository.ImageRepository;
import br.com.framework.api.frameworkapi.repository.PhotoAlbumRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/album")
public class PhotoAlbumController {
	
	@Autowired
	PhotoAlbumRepository photoAlbumRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@GetMapping
	public List<PhotoAlbumDto> getAllPhotoAlbum() {
		List<PhotoAlbum> album = photoAlbumRepository.findAll();
		return PhotoAlbumDto.converter(album);
	}
	
	@PostMapping
	public ResponseEntity<PhotoAlbumDto> createPhotoAlbum(@RequestBody @Valid PhotoAlbumForm form, UriComponentsBuilder uriBuilder) {
		PhotoAlbum album = form.convert(photoAlbumRepository);
		photoAlbumRepository.save(album);

		URI uri = uriBuilder.path("/album/{id}").buildAndExpand(album.getId()).toUri();

		// this method encapsulates the implementation do insert new image
		form.newImage(imageRepository, album);

		return ResponseEntity.created(uri).body(new PhotoAlbumDto(album));
	}

}
