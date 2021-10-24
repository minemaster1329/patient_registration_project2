package org.patient_registration_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console app main class, contains main method
 */
public class App
{
    /**
     * Console app main function. Everything starts and finishes here
     * @param args command line arguments
     */
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        IErrorCommunicationStrategy iErrorCommunicationStrategy = new ConsoleErrorCommunicationStrategy();
        PatientRegistrationSystemController.initializeModelSingleton(iErrorCommunicationStrategy);
        while (result != 2){
            ConsoleViewMenusSingleton.drawMainMenu();
            result = Integer.parseInt(sc.nextLine());
            switch (result){
                case 0:
                    Patient pat = askForPatientData();
                    PatientRegistrationSystemController.AddNewPatientToDb(pat, iErrorCommunicationStrategy);
                    System.out.println("Patient added successfully");
                    break;
                case 1:
                    List<Patient> list = PatientRegistrationSystemController.getAllPatients();
                    for (Patient p : list) ConsoleViewMenusSingleton.printOutPatient(p);
                    System.out.println("End of patient's list. Press any key to return to menu...");
                    sc.nextLine();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option selected!");
                    break;
            }
        }
    }

    /**
     * prompts user for new patient data
     * @return new patient object with data given by user
     */
    private static Patient askForPatientData(){
        String name = promptForString("Enter name:");
        String surname = promptForString("Enter surname: ");
        String email = promptForString("Enter email:");

        return new Patient(name, surname, email);
    }


    /**
     * prompts user for some data
     * @param prompt prompt char sequence
     * @return string with user input
     */
    private static String promptForString(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * prints main menu options
     */
    private static void printOptions(){
        System.out.print("\033[H\033[2J");
        System.out.println("Choose action:");
        System.out.println("[0] add new patient.");
        System.out.println("[1] print out all patients.");
        System.out.println("[2] exit.");
    }
}
