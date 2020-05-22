package com.PhotoApplicationUserClient.api.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PhotoApplicationUserClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoApplicationUserClientApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncode() {
		return new BCryptPasswordEncoder();
	}

}
