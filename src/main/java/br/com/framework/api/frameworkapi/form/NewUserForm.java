package br.com.framework.api.frameworkapi.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.framework.api.frameworkapi.model.User;
import br.com.framework.api.frameworkapi.repository.UserRepository;

public class NewUserForm {

	private String username;
	private String pwd;

	public NewUserForm() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public User convert(UserRepository userRepository) {
		pwd = new BCryptPasswordEncoder().encode(pwd);
		return new User(username, pwd);
	}

}
