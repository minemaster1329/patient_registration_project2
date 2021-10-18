package org.patient_registration_system;

import java.util.ArrayList;

public class JsonDatabaseSingleton {
    private static JsonDatabaseSingleton instance = null;

    ArrayList<Patient> patientArrayList = null;

    private JsonDatabaseSingleton(){
        patientArrayList = new ArrayList<>();
    }

    public static JsonDatabaseSingleton getInstance() {
        if (instance == null){
            instance =  new JsonDatabaseSingleton();
        }
        return instance;
    }

    public void printHelloWorld() {
        System.out.println("Hello World!");
    }

    public void addNewPatient(String name, String surname, String email){
        Patient pt = new Patient(name, surname, email);
        patientArrayList.add(pt);
        System.out.println("Patient added successfully");
    }
}
