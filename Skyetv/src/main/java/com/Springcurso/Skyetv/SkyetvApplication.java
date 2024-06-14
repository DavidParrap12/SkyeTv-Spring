package com.Springcurso.Skyetv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyetvApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SkyetvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Mundo desde Spring");
	}
}
