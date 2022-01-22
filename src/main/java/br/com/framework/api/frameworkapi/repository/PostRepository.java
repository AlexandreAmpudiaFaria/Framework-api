package br.com.framework.api.frameworkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.framework.api.frameworkapi.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	Post getById(Integer id);

}
