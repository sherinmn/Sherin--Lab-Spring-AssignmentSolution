package com.greatlearning.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringBootStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentApplication.class, args);
	}

}
