package com.devsuperior.felipe.dscommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DscommerceApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(DscommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(encoder.encode("123456"));
		System.out.println(encoder.matches("123456", "$2a$10$znVFaytbX.Hf9E220cxGxuZoJbAFVFuXTanWoa43GICXL7kEGsE0G"));
	}
}
