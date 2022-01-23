package br.com.framework.api.frameworkapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.framework.api.frameworkapi.dto.ImageDto;
import br.com.framework.api.frameworkapi.form.ImageForm;
import br.com.framework.api.frameworkapi.model.Image;
import br.com.framework.api.frameworkapi.repository.ImageRepository;
import br.com.framework.api.frameworkapi.repository.PostRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/images")
public class ImageController {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	PostRepository postRepository;

	@GetMapping
	public List<ImageDto> getAllImages() {
		List<Image> images = imageRepository.findAll();
		return ImageDto.convert(images);
	}

	@PostMapping
	public ResponseEntity<ImageDto> saveImage(@RequestBody @Valid ImageForm values, UriComponentsBuilder uriBuilder) {
		Image images = values.convert(imageRepository, postRepository);
		imageRepository.save(images);

		URI uri = uriBuilder.path("/images/{id}").buildAndExpand(images.getId()).toUri();
		return ResponseEntity.created(uri).body(new ImageDto(images));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removeImage(Long id) {
		Optional<Image> optional = imageRepository.findByPost(id);
		if (optional.isPresent()) {
			imageRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
