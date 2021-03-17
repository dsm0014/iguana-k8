package com.dsm.iguana.api;

import com.dsm.iguana.api.service.IguanaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IguanaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IguanaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		IguanaService.loadIguanaData();
	}

}
