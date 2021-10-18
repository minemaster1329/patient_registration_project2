package org.patient_registration_system;

public class Patient {
    public String name;
    public String surname;
    public String email;

    private Patient(){}

    public Patient(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
