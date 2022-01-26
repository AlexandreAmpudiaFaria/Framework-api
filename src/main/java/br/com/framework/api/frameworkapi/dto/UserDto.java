package br.com.framework.api.frameworkapi.dto;

import br.com.framework.api.frameworkapi.model.User;

public class UserDto {

	private Long id;
	private String username;

	public UserDto() {

	}

	public UserDto(User user) {
		this.id = user.getId();
		this.username = user.getUser();
	}
	
	public UserDto(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
