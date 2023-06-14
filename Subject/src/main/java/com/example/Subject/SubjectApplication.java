package com.example.Subject;

import com.example.Exercise2.ConvertCelsiusToFahrenheit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);

		System.out.println("Exercise 2: Convertir grados Centigrados a Farenheit.");
		Scanner scanCelsius = new Scanner(System.in);
		System.out.println("Ingrese a continuación los grados Centigrados que desea convertir a Farenheit: ");
		double celsius = scanCelsius.nextDouble();
		ConvertCelsiusToFahrenheit exercise2 = new ConvertCelsiusToFahrenheit();
		double result = exercise2.convertCelsiusToFahrenheit(celsius);
		System.out.println("La conversión de los grados Centigrados a Farenheit es de: " + result + "°" + "\n");


	}

}
