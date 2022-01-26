package br.com.framework.api.frameworkapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.framework.api.frameworkapi.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value = "SELECT * FROM post p WHERE p.comments = :cod", nativeQuery = true)
	List<Comment> findByPost(@Param("cod") Long result);

	@Query(value = "SELECT user_id FROM comment c WHERE c.id = :cod", nativeQuery = true)
	Long findByUser(@Param("cod") Long result);

}
