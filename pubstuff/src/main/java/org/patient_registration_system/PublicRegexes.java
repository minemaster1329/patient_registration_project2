package org.patient_registration_system;

public class PublicRegexes {
    public static final String nameRegex = "^[A-Z][a-z]+$";
    public static final String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String peselRegex = "^\\d{11}$";
}
