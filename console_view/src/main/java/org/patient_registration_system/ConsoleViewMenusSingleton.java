package org.patient_registration_system;

import exceptions.InvalidEmailFormatException;
import models.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Class with menu drawing functions
 */
public class ConsoleViewMenusSingleton {
    /**
     * draws Main Menu
     */
    public static void drawMainMenu(){
        System.out.print("\033[H\033[2J");
        System.out.println("Choose action:");
        System.out.println("[0] add new patient.");
        System.out.println("[1] print out all patients.");
        System.out.println("[2] edit patient's email.");
        System.out.println("[3] delete all patients.");
        System.out.println("[4] exit.");
    }

    /**
     * prints out single patient to console
     * @param pt patient object
     */
    public static void printOutPatient(Patient pt){
        if (pt == null) return;
        System.out.println("ID: "+pt.getId());
        System.out.println("Name: "+pt.getName());
        System.out.println("Surname: "+pt.getSurname());
        System.out.println("Email: "+pt.getEmail());
        System.out.println("End of current patient's data");
    }

    public static void printOutAllPatients(){
        System.out.println("Begin of Patient's list");
        PatientRegistrationSystemController.getAllPatients().forEach(ConsoleViewMenusSingleton::printOutPatient);
    }

    /**
     * prints email edit menu and handles editing patient's email
     */
    public static void editPatientsEmail(){

    }

    /**
     * Shows help for program (used when program run with -h switch)
     */
    public static void showHelp(){
        System.out.println("Patient's registration system");
        System.out.println("Version: 1.0");
        System.out.println("Run program without parameters to access database");
        System.out.println("Run program with -h switch to view help");
        System.out.println("Run program with -c switch to wipe out database");
    }

    /**
     * Asks user for database wipe out
     */
    public static void askForDatabaseWipeOut(){
        System.out.println("You are about to clear whole database...");
        String input = "";
        while (!input.equals("n") && !input.equals("y")){
            input = promptForString("Are you sure? (y/n)");
        }

        if (input.equals("y")){
            PatientRegistrationSystemController.DeleteAllPatients(new ConsoleErrorCommunicationStrategy());
            System.out.println("Database cleared successfully");
        }

        else {
            System.out.println("Operation cancelled...");
        }
    }

    /**
     * Asks user for some input
     * @param prompt string displayed as prompt
     * @return string entered by user
     */
    public static String promptForString(String prompt){
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static Pair<Boolean, Patient> askForNewPatientData(IErrorCommunicationStrategy errorCommunicationStrategy){
        Pair<Boolean, Patient> output = new Pair<>(true, new Patient());

        Pair<Boolean, String> temp = PatientsDataAskSingleton.askForNewPatientsID();

        output.element1 |= temp.element1;

        if (output.element1){
            try {
                output.element2.setId(temp.element2);
            }
            catch (Exception e) {
                output.element1 = false;
                errorCommunicationStrategy.writeError("Error when saving patient's ID", e.getMessage());
            }
        }

        if (output.element1){

        }

        return output;
    }
}
