package br.com.framework.api.frameworkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.framework.api.frameworkapi.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long>{

}
