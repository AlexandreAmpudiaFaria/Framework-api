package br.com.framework.api.frameworkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.framework.api.frameworkapi.model.PhotoAlbum;

public interface PhotoAlbumRepository extends JpaRepository<PhotoAlbum, Long>{

	@Query(value = "SELECT user_id FROM photo_album p WHERE p.id = :cod", nativeQuery = true)
	Long findByUser(@Param("cod") Long id);

}
