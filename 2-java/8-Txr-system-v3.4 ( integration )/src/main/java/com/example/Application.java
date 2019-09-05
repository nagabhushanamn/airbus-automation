package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner clRunnner(AccountRepository accountRepository) {
//		return args -> {
//			System.out.println("cl runner");
//			accountRepository.findAll().forEach(System.out::println);
//		};
//	}

}
