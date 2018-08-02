package com.dbs.askleader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class AskleaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskleaderApplication.class, args);
	}	
}
