package org.patient_registration_system.javafx_view.pubstuff;

public class PublicRegexes {
    public static final String nameRegex = "^[A-Z][a-z]+$";
    public static final String emailRegex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
    public static final String peselRegex = "^\\d{11}$";
    public static final String medicineNameRegex = "^[A-z][a-z]*\\d*$";
}
