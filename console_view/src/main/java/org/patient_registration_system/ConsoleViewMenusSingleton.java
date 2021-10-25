package org.patient_registration_system;

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
        System.out.println("[3] exit.");
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

    /**
     * prints email edit menu and handles editing patient's email
     */
    public static void editPatientsEmail(){
        List<Patient> patients = PatientRegistrationSystemController.getAllPatients();
        System.out.println("Existing patients");
        for (Patient p : patients) System.out.println(p.getId());
        Scanner sc = new Scanner(System.in);
        String input;
        boolean exited = false;
        long id = 0L;
        do {
            System.out.print("Enter patient's id to edit (enter q to exit):");
            input = sc.nextLine();
            if (input.equals("q")) {
                exited = true;
                break;
            }
            else if (longCanParse(input)){
                id = Long.parseLong(input);
                if (patients.stream().map(Patient::getId).toList().contains(id)){
                    System.out.println("Selected patient with ID "+id);
                    break;
                }
                else {
                    System.out.println("Patient with specified ID does not exists");
                }
            }
            else System.out.println("Invalid patient's id. Enter correct patient's id or q for exit");
        } while (true);
        if (!exited){
            final Long pat_id = id;
            Patient pt = PatientRegistrationSystemController.getPatientByID(id).get();
            System.out.println("Enter new patient's email");
            while (true){
                try {
                    input = sc.nextLine();
                    pt.setEmail(input);
                    System.out.println("Patient's id changed successfully");

                    break;
                }
                catch (InvalidEmailFormatSetException e){
                    System.out.println("Invalid email entered");
                }

            }
        }
    }

    /**
     * checks if input string can be parsed to long
     * @param input input string
     * @return true when parsing string to long is possible with no issues
     */
    public static boolean longCanParse(String input){
        try{
            Long a = Long.parseLong(input);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
