package com.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/*@EnableGlobalMethodSecurity(securedEnabled = true)*/
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("user").password("user").roles("USER").and()
			.withUser("admin").password("admin").roles("USER","ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		/*http.httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login","/logout").permitAll()
		.anyRequest().authenticated();*/
		
		http.formLogin().loginPage("/login").defaultSuccessUrl("/home")
		.and()
		.logout().logoutSuccessUrl("/login")
		.and()
		.authorizeRequests()
		.antMatchers("/webjar/**","/login","/listAll").permitAll()
		.anyRequest().authenticated();
	}
}
