package org.patient_registration_system;

import java.util.Scanner;

public class PatientRegistrationSystemController {
    public static void printHelloWorld(){
        JsonDatabaseSingleton.getInstance().printHelloWorld();
    }

    public static void askForData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name:");
        String name = sc.nextLine();
        System.out.print("Enter surname:");
        String surname = sc.nextLine();
        System.out.print("Enter email:");
        String email = sc.nextLine();
        sc.close();
        JsonDatabaseSingleton.getInstance().addNewPatient(name, surname, email);
    }
}
