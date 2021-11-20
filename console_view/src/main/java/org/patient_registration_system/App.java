package org.patient_registration_system;

import exceptions.InvalidEmailFormatException;
import exceptions.InvalidNameFormatException;
import exceptions.InvalidSurnameFormatException;
import models.Patient;

import java.util.Scanner;

/**
 * Console app main class, contains main method
 */
public class App
{
    /**
     * Console app main function. Everything starts and finishes here
     * @param args command line arguments (-h for help; -c to clear database)
     */
    public static void main( String[] args )
    {
        if (args.length == 0){
            Scanner sc = new Scanner(System.in);
            int result = 0;
            String result_str;
            IErrorCommunicationStrategy errorCommunicationStrategy = new ConsoleErrorCommunicationStrategy();
            if (PatientRegistrationSystemController.initializeModelSingleton(errorCommunicationStrategy)){
                loop: while (result != 4){
                    ConsoleViewMenusSingleton.drawMainMenu();
                    result_str = sc.nextLine();
                    if (!PublicStaticMethods.canParseToInt(result_str))  result = -1;
                    else result = Integer.parseInt(result_str);
                    switch (result) {
                        case 0 -> promptForPatientDataAndAdd(errorCommunicationStrategy);
                        case 1 -> {
                            ConsoleViewMenusSingleton.printOutAllPatients();
                        }
                        case 2 -> ConsoleViewMenusSingleton.editPatientsEmail();
                        case 3 -> {
                            PatientRegistrationSystemController.DeleteAllPatients(errorCommunicationStrategy);
                            System.out.println("All patients have been removed...");
                            sc.nextLine();
                        }
                        case 4 -> {
                            break loop;
                        }
                        default -> System.out.println("Invalid option selected!");
                    }
                }
            }
        }

        else if (args[0].equals("-h")){
            ConsoleViewMenusSingleton.showHelp();
        }

        else if (args[0].equals("-c")){
            ConsoleViewMenusSingleton.askForDatabaseWipeOut();
        }

        else {
            System.out.println("unknown command line parameter: "+args[0]);
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
            return null;
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

    private static void promptForPatientDataAndAdd(IErrorCommunicationStrategy errorCommunicationStrategy){
        Patient pt = new Patient();
        System.out.println("Enter new patient's data (or q to exit)");
        boolean not_cancelled = true;

        do {
            String input = promptForString("Enter patient's name: ");
            try {
                if (input.equals("q")){
                    not_cancelled = false;
                    break;
                }
                pt.setName(input);
                break;
            }
            catch (InvalidNameFormatException e){
                System.out.println("Invalid name");
            }
        } while (not_cancelled);

        while (not_cancelled){
            String input = promptForString("Enter patient's surname: ");
            try {
                if (input.equals("q")){
                    not_cancelled = false;
                    break;
                }
                pt.setSurname(input);
                break;
            }
            catch (InvalidSurnameFormatException e){
                System.out.println("Invalid surname");
            }
        }

        while (not_cancelled){
            String input = promptForString("Enter patient's name: ");
            try {
                if (input.equals("q")){
                    not_cancelled = false;
                    break;
                }
                pt.setEmail(input);
                break;
            }
            catch (InvalidEmailFormatException e){
                System.out.println("Invalid name");
            }
        }

        if (not_cancelled){
            PatientRegistrationSystemController.AddNewPatientToDb(pt, errorCommunicationStrategy);
            System.out.println("Patient added successfully...");
        }

        else {
            System.out.println("Operation has been cancelled");
        }
    }
}
