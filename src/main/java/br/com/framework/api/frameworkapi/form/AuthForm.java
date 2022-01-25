package br.com.framework.api.frameworkapi.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthForm {

	private String username;
	private String pwd;

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

	public UsernamePasswordAuthenticationToken convert() {
		return new UsernamePasswordAuthenticationToken(username, pwd);
	}

}
