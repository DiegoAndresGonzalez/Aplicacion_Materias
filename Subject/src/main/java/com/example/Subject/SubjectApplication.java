package com.example.Subject;

import com.example.Subject.models.Patient;
import com.example.Subject.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(SubjectApplication.class, args);

		Scanner askData = new Scanner(System.in);
		PatientRepository patientRepository = context.getBean(PatientRepository.class);
		new Patient();
		Patient patient;
		boolean exitFlag = false;

		while(!exitFlag){

			System.out.println("Welcome Doctor, what do you want to do?\n(introduce data/look for data/exit)");
			String choose = askData.nextLine();

			if (choose.equalsIgnoreCase("introduce data")){
				patient = new Patient();
				patient = patientRepository.save(patient);
				System.out.println("Please introduce patient's data, the ID you are actually working on is: " + patient.getId());

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
						askData.nextLine();
						patient.setDocument(document);
					} else if (option.equalsIgnoreCase("phone")){
						System.out.println("Please introduces patient's phone:");
						Integer phone = askData.nextInt();
						askData.nextLine();
						patient.setPhone(phone);
					} else if (option.equalsIgnoreCase("last visit")){
						System.out.println("Please introduces patient's last visit (dd/MM/yyyy): ");
						String lastVisitStr = askData.nextLine();
						String dateFormat = "dd/MM/yyyy";
						DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
						LocalDate lastVisit = LocalDate.parse(lastVisitStr, dateFormatter);
						patient.setLastVisit(lastVisit);
					} else if (option.equalsIgnoreCase("social security")){
						System.out.println("Please introduce if patient has or doesn't have social security");
						String privateSocial = askData.nextLine();
						patient.setPrivate_social(privateSocial);
					} else if (option.equalsIgnoreCase("allergies")){
						System.out.println("Please introduce patient's allergies:");
						String allergies = askData.nextLine();
						patient.setAllergies(allergies);
					} else if (option.equalsIgnoreCase("observations")){
						System.out.println("Please introduce any observations you have about this patient:");
						String observations = askData.nextLine();
						patient.setObservations(observations);
					} else if (option.equalsIgnoreCase("new")){
						patientRepository.save(patient);
						System.out.println("Your actual patient has been saved, making a new patient.");
						patient = new Patient();
						patient = patientRepository.save(patient);
						System.out.println("Making a new user, id: " + patient.getId() + "\n");
						continue;
					} else if (option.equalsIgnoreCase("exit")){
						System.out.println("Returning to main menu.");
						break;
					} else {
						System.out.println("Invalid option or not chosen. Please choose a valid option.");
					}
					patientRepository.save(patient);
				}
			}
				if (choose.equalsIgnoreCase("look for data")){

					while(true){
						System.out.println("Which type of search do you want to do?\nall/last visit/allergies/social/exit");
						String optionSearch = askData.nextLine();
						if (optionSearch.equalsIgnoreCase("all")){
							System.out.println("Showing all patients data:");
							List<Patient> patientList = patientRepository.findAllByOrderByIdAsc();
								for (Patient patients : patientList) {
									System.out.println(patients.queryToString());
								}
						} else if (optionSearch.equalsIgnoreCase("last visit")){
							System.out.println("To find a patient's last visit, please introduce his/her document:");
							Integer document = askData.nextInt();
							askData.nextLine();
							List<LocalDate> lastVisits = patientRepository.findLastVisitByDocument(document);
							if (!lastVisits.isEmpty()) {
								System.out.println("Patient's last visit found, it was on the day: ");
								for (LocalDate lastVisitList : lastVisits) {
									System.out.println(lastVisitList);
								}
							} else {
								System.out.println("The document introduced doesn't exist or doesn't have a last visit.");
							}
						} else if (optionSearch.equalsIgnoreCase("allergies")) {
							List<Patient> allergyList = patientRepository.findAllByAllergiesIsNotNull();
							if (!allergyList.isEmpty()) {
								System.out.println("Patients with allergies: ");
								for (Patient allergy : allergyList) {
									System.out.println(allergy.queryToString());
								}
							} else {
								System.out.println("There are no patients with allergies.");
							}
						} else if (optionSearch.equalsIgnoreCase("social")){
							List<Patient> socialList = patientRepository.findAllBySocialSecurityIsNotNull();
							if (!socialList.isEmpty()) {
								System.out.println("Patients with social security");
								for (Patient social : socialList) {
									System.out.println(social.queryToString());
								}
							} else {
								System.out.println("There are no patients with social security.");
							}
						} else if (optionSearch.equalsIgnoreCase("exit")) {
							System.out.println("Returning to main menu.");
							break;
						} else {
							System.out.println("Invalid option or not introduced. Please introduce a valid option.");
						}
					}
				} else if (choose.equalsIgnoreCase("exit")){
				System.out.println("Closing application, have a nice day Doctor.");
				exitFlag = true;
				} else {
					System.out.println("Invalid option or not introduced. Please introduce a valid option.");
				}
		}
	}
}