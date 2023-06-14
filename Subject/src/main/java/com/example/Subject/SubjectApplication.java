package com.example.Subject;

import com.example.Exercise1.ConvertCelsiusToKelvin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);

		System.out.println("exercise 1: Convertir de grados centigrados a kelvin");
		Scanner scannerCelius = new Scanner(System.in);
		System.out.print("Por favor digite los grados centigrados que desea convertir: ");
		double celsius = scannerCelius.nextDouble();
		ConvertCelsiusToKelvin exercise1 = new ConvertCelsiusToKelvin();
		double result = exercise1.convertCelsiusToKelvin(celsius);
		System.out.println("La conversion de grados centigrados a kelvin son de: "+ result + "\n");

	}

}
