package com.example.Subject;

import com.example.Subject.models.Patient;
import com.example.Subject.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SubjectApplication.class, args);

		Scanner askData = new Scanner(System.in);
		PatientRepository patientRepository = context.getBean(PatientRepository.class);
		Patient patient = new Patient();
		boolean exitFlag = false;

		while(!exitFlag){

			System.out.println("Welcome Doctor, what do you want to do?\n(introduce data/look for data/exit)");
			String choose = askData.nextLine();

			if (choose.equalsIgnoreCase("introduce data")){
				System.out.println("Please introduce patient's data, the ID you are actually working on is: ");

				while(true){
					System.out.println("Which data do you want to introduce?\n(name/document/phone/last visit/social security/allergies/observations/new(for making a new user))\nID you are currently working on: " + patient.getId());
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
					} else if (option.equalsIgnoreCase("social security")){
						System.out.println("Please introduce if patient has or doesn't have social security");
						String private_social = askData.nextLine();
						patient.setPrivate_social(private_social);
					} else if (option.equalsIgnoreCase("allergies")){
						System.out.println("Please introduce patient's allergies.\nIf he/she doesn't have, insert: Patient doesn't have allergies:");
						String allergies = askData.nextLine();
						patient.setAllergies(allergies);
					} else if (option.equalsIgnoreCase("observations")){
						System.out.println("Please introduce any observations you have about this patient:");
						String observations = askData.nextLine();
						patient.setObservations(observations);
					} else if (option.equalsIgnoreCase("new")){
						patientRepository.save(patient);
						System.out.println("Your actual patient has been saved, making a new patient.");
						patient = patientRepository.save(patient);
						System.out.println("Making a new user, id: " + patient.getId() + "\n");
						continue;
					} else if (option.equalsIgnoreCase("exit")){
						System.out.println("Returning to main menu.");
						break;
					}
					patientRepository.save(patient);
				}
			}
				if (choose.equalsIgnoreCase("look for data")){

				} else if (choose.equalsIgnoreCase("exit")){
				System.out.println("Closing application, have a nice day Doctor.");
				exitFlag = true;
				}
		}
	}
}