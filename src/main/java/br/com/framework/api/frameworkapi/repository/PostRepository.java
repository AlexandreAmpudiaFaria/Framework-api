package br.com.framework.api.frameworkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.framework.api.frameworkapi.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	Post getById(Integer id);

	@Query(value = "SELECT user_id FROM post p WHERE p.id = :cod", nativeQuery = true)
	Long findByUser(@Param("cod") Long id);

}
