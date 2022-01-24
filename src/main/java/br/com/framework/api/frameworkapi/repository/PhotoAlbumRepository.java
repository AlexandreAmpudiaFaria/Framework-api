package br.com.framework.api.frameworkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.framework.api.frameworkapi.model.PhotoAlbum;

public interface PhotoAlbumRepository extends JpaRepository<PhotoAlbum, Long>{

}
