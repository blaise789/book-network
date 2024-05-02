package com.blaiseCoder.userAuthApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserAuthAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthAppApplication.class, args);
	}

}
