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
        String result_str = "";
        IErrorCommunicationStrategy iErrorCommunicationStrategy = new ConsoleErrorCommunicationStrategy();
        PatientRegistrationSystemController.initializeModelSingleton(iErrorCommunicationStrategy);
        while (result != 4){
            ConsoleViewMenusSingleton.drawMainMenu();
            result_str = sc.nextLine();
            if (!PublicStaticMethods.canParseToInt(result_str))  result = -1;
            else result = Integer.parseInt(result_str);
            switch (result) {
                case 0 -> {
                    Patient pat = askForPatientData();
                    PatientRegistrationSystemController.AddNewPatientToDb(pat, iErrorCommunicationStrategy);
                    System.out.println("Patient added successfully");
                }
                case 1 -> {
                    List<Patient> list = PatientRegistrationSystemController.getAllPatients();
                    list.forEach(ConsoleViewMenusSingleton::printOutPatient);
                    System.out.println("End of patient's list. Press any key to return to menu...");
                    sc.nextLine();
                }
                case 2 -> ConsoleViewMenusSingleton.editPatientsEmail();
                case 3 -> {
                    PatientRegistrationSystemController.DeleteAllPatients(iErrorCommunicationStrategy);
                    System.out.println("All patients have been removed...");
                    sc.nextLine();
                }
                case 4 -> {

                }
                default -> System.out.println("Invalid option selected!");
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

        Patient pt = new Patient();
        try {
            pt.setEmail(email);
            pt.setName(name);
            pt.setSurname(surname);
        }
        catch(Exception e){

        }

        return pt;
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
