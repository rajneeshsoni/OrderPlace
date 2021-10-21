package com.order.orderplace.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.order.orderplace.api.filter.JwtRequestFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		///*
		http.csrf().disable().authorizeRequests().antMatchers("/authenticate","/h2-console/login.jsp")
				.permitAll()
				
				.antMatchers("/dummy/**").permitAll()
				.antMatchers("/web/**").permitAll()
				.antMatchers("/").permitAll()
				//.antMatchers("").permitAll()
				.anyRequest()
				.authenticated() .and().sessionManagement().enableSessionUrlRewriting(true) 
				 .sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

}

