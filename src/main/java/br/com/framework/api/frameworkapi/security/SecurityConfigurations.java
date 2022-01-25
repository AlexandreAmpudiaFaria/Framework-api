package br.com.framework.api.frameworkapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	//Authentication Settings
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    }
     
    //Authorization settings
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.anyRequest()
    	.authenticated()
    	.and()
    	.formLogin();
    }
    
    //Static resource settings (js, css, images)
    @Override
    public void configure(WebSecurity web) throws Exception {
    	
    }
     
     

}
