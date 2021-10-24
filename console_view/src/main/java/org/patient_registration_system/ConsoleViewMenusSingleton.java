package org.patient_registration_system;

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
        System.out.println("ID: "+pt.id);
        System.out.println("Name: "+pt.name);
        System.out.println("Surname: "+pt.surname);
        System.out.println("Email: "+pt.email);
        System.out.println("End of current patient's data");
    }
}
