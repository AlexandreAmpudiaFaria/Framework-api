package br.com.framework.api.frameworkapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Profile implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameProfile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameProfile() {
		return nameProfile;
	}

	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}

	@Override
	public String getAuthority() {
		return nameProfile;
	}

}
