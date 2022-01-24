package br.com.framework.api.frameworkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.framework.api.frameworkapi.model.StatusPost;

public interface StatusRepository extends JpaRepository<StatusPost, Integer>{



}
