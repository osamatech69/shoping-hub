package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	@Test
	public void testEncodePassword(){
		BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
		String password="osama#12";
		String encodePassword=passwordEncoder.encode(password);
		System.out.println(encodePassword);
		boolean matches =passwordEncoder.matches(password, encodePassword);
		assertThat(matches).isTrue();	
		
	}
}
