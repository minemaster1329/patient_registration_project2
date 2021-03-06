package org.patient_registration_system.javafx_view;

import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;
import org.patient_registration_system.javafx_view.models.Patient;
import org.patient_registration_system.javafx_view.pubstuff.IErrorCommunicationStrategy;
import org.patient_registration_system.javafx_view.pubstuff.Pair;

import java.util.List;
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
        System.out.println("Gender: "+pt.getGender());
        System.out.println("End of current patient's data");
    }

    public static void printOutAllPatients(){
        System.out.println("Begin of Patient's list");
        List<Patient> pts = PatientRegistrationSystemController.getAllPatients();
        for (Patient pt : pts){
            printOutPatient(pt);
        }
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

    /**
     * asks for new patient's data
     * @param errorCommunicationStrategy strategy for communicating errors
     * @return Pair of boolean (was operation confirmed by user) and new Patient object
     */
    public static Pair<Boolean, Patient> askForNewPatientData(IErrorCommunicationStrategy errorCommunicationStrategy){
        Pair<Boolean, Patient> output = new Pair<>(true, new Patient());

        Pair<Boolean, String> temp = PatientsDataAskSingleton.askForNewPatientsID();

        output.element1 &= temp.element1;

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
            temp = PatientsDataAskSingleton.askForNewPatientsName();
            output.element1 &= temp.element1;
            if (!output.element1) return output;
            try {
                output.element2.setName(temp.element2);
            }
            catch (Exception e) {
                output.element1 = false;
                errorCommunicationStrategy.writeError("Error when saving patient's name", e.getMessage());
            }
        }

        if (output.element1){
            temp = PatientsDataAskSingleton.askForNewPatientsSurname();
            output.element1 &= temp.element1;
            if (output.element1){
                try {
                    output.element2.setSurname(temp.element2);
                }
                catch (Exception e) {
                    output.element1 = false;
                    errorCommunicationStrategy.writeError("Error when saving patient's surname", e.getMessage());
                }
            }
        }

        if (output.element1){
            temp = PatientsDataAskSingleton.askForNewPatientsMiddleName();
            output.element1 &= temp.element1;
            if (output.element1){
                try {
                    output.element2.setMiddleName(temp.element2);
                }
                catch (Exception e) {
                    output.element1 = false;
                    errorCommunicationStrategy.writeError("Error when saving patient's middle name", e.getMessage());
                }
            }
        }

        if (output.element1){
            temp = PatientsDataAskSingleton.askForNewPatientsEmail();
            output.element1 &= temp.element1;
            if (output.element1){
                try {
                    output.element2.setEmail(temp.element2);
                }
                catch (Exception e) {
                    output.element1 = false;
                    errorCommunicationStrategy.writeError("Error when saving patient's email", e.getMessage());
                }
            }
        }

        return output;
    }
}
