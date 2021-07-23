package com.aisen.book.spring_boot_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookApplication.class, args);
	}

}
