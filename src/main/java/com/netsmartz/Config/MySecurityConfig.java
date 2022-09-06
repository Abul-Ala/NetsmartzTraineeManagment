package com.netsmartz.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


import com.netsmartz.Service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired 
	private CustomUserDetailService customUserDetailService; 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		      .authorizeRequests()
		      .antMatchers("/signin").permitAll()
		      .anyRequest()
		      .authenticated()
		      .and()
		      .formLogin()
		      .loginPage("/signin")
		      .loginProcessingUrl("/dologin")
		      .defaultSuccessUrl("/home");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
	
	return new BCryptPasswordEncoder(10);
	}

}
