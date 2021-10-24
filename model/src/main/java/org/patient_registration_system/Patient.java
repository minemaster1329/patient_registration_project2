package org.patient_registration_system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patient {
    private Long id;
    private String name;
    private String surname;
    private String email;

    private Patient(){}

    public Patient(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail(){
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) throws InvalidEmailFormatSetException {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher mc = pattern.matcher(email);
        if (!mc.matches()) throw new InvalidEmailFormatSetException("Trying to set invalid email for patient "+this.id);
        this.email = email;
    }
}
