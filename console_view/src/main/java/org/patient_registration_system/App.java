package org.patient_registration_system;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Choose action:");
        System.out.println("[0] add new patient:");
        System.out.println("[1] exit:");

        Scanner sc = new Scanner(System.in);
        int result = Integer.parseInt(sc.nextLine());
        sc.close();
        if (result == 0) {
            PatientRegistrationSystemController.askForData();
        }
    }
}
