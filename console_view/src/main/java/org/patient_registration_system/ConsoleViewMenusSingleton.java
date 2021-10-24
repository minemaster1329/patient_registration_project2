package org.patient_registration_system;

import java.util.List;
import java.util.Scanner;

public class ConsoleViewMenusSingleton {
    public static void drawMainMenu(){
        System.out.print("\033[H\033[2J");
        System.out.println("Choose action:");
        System.out.println("[0] add new patient.");
        System.out.println("[1] print out all patients.");
        System.out.println("[2] exit.");
    }

    public static void printOutPatient(Patient pt){
        if (pt == null) return;
        System.out.println("ID: "+pt.getId());
        System.out.println("Name: "+pt.getName());
        System.out.println("Surname: "+pt.getSurname());
        System.out.println("Email: "+pt.getEmail());
        System.out.println("End of current patient's data");
    }

    public static void editPatientsEmail(){
        List<Patient> patients = PatientRegistrationSystemController.getAllPatients();
        System.out.println("Existing patients");
        for (Patient p : patients) System.out.println(p.getId());
        System.out.print("Enter patient's id to edit:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        do {

        } while (!input.equals("q"));
    }
}
