package br.com.framework.api.frameworkapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.framework.api.frameworkapi.form.ImageForm;
import br.com.framework.api.frameworkapi.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

	Optional<Image> findByPost(Long id);

	void save(ImageForm result);

}
