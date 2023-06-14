package com.example.Subject;

import com.example.Exercise1.ConvertCelsiusToKelvin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);

		ConvertCelsiusToKelvin exercise1 = new ConvertCelsiusToKelvin();
		
	}

}
