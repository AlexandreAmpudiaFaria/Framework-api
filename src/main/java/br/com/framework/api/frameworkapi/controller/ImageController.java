package br.com.framework.api.frameworkapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/images")
public class ImageController {

	/*@Autowired
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
	}*/

}
