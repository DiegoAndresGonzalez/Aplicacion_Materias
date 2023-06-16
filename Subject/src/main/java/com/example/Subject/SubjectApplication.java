package com.example.Subject;

import com.example.Subject.models.Patient;
import com.example.Subject.repositories.PatientRepository;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SubjectApplication.class, args);

		Scanner askData = new Scanner(System.in);
		PatientRepository patientRepository = context.getBean(PatientRepository.class);
		Patient patient = new Patient();

		System.out.println("Welcome Doctor, please introduce patient's data:");

		while(true){
			System.out.println("Which data do you want to introduce?\n(name/document/phone/last visit/private social/allergies/observations)");
			String option = askData.nextLine();

			if (option.equalsIgnoreCase("name")){
				System.out.println("Please introduce patient's name:");
				String name = askData.nextLine();
				patient.setName(name);
			} else if (option.equalsIgnoreCase("document")){
				System.out.println("Please introduce patient's document:");
				Integer document = askData.nextInt();
				patient.setDocument(document);
			} else if (option.equalsIgnoreCase("phone")){
				System.out.println("Please introduces patient's phone:");
				Integer phone = askData.nextInt();
				patient.setPhone(phone);
			} else if (option.equalsIgnoreCase("last visit")){
				System.out.println("Please introduces patient's last visit (dd/MM/yyyy): ");
				String last_visitStr = askData.nextLine();
				String dateFormat = "dd/MM/yyyy";

				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
				LocalDate last_visit = LocalDate.parse(last_visitStr, dateFormatter);
				patient.setLast_visit(last_visit);
				System.out.print(last_visit);
			} else if (option.equalsIgnoreCase("exit")){
				System.out.println("Closing application.");
				break;
			}

		}
		patientRepository.save(patient);
	}

}