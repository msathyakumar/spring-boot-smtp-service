package com.spring.smtp.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSmtpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSmtpServiceApplication.class, args);
	}

}
