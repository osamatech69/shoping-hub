
package com.shopme.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	/*@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Bean
	public static BCryptPasswordEncoder bcryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
	        http.authorizeHttpRequests((authz)->authz.anyRequest().permitAll());
	        return http.build();
	}

}
