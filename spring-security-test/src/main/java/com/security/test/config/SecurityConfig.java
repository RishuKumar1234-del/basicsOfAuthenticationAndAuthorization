package com.security.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	
	@Bean
	public PasswordEncoder getPasswordEncoderInstance() {
		
		return new BCryptPasswordEncoder();
	}
	
		//authentication
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		//first user
		UserDetails admin =User.withUsername("Rishu")
				         .password(encoder.encode("rishu123"))
				         .roles("ADMIN")
				         .build();
		//second user
		UserDetails user=User.withUsername("Ranjeet")
		         .password(encoder.encode("raju123"))
		         .roles("USER")
		         .build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	//autherization
	
	@Bean
	public SecurityFilterChain getSecurityFilterChainIntstance(HttpSecurity http)  throws Exception{
		
	  return	http.csrf().disable()
		    .authorizeHttpRequests()
		    .requestMatchers("Product/test").permitAll()
		    .and()
		    .authorizeHttpRequests().requestMatchers("/Product/**")
		    .authenticated()
		    .and().formLogin().and().build();
		
		
	
	

}



}
