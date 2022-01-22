package br.com.framework.api.frameworkapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.framework.api.frameworkapi.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value = "SELECT * FROM comment c WHERE c.post_id = :cod", nativeQuery = true)
	List<Comment> findByPost(@Param("cod") Long result);

}
