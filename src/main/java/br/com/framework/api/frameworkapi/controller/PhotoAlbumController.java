package br.com.framework.api.frameworkapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.framework.api.frameworkapi.dto.PhotoAlbumDto;
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

}
