package com.one.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
@EnableScheduling
public class Gdj89SpringBootMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(Gdj89SpringBootMavenApplication.class, args);
	}

}
