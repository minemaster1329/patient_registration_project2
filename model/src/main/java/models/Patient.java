package models;

import exceptions.InvalidEmailFormatException;
import org.patient_registration_system.PublicRegexes;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Stores data about patient
 */
public class Patient extends Person {
    private String email = null;

    /**
     * default patient constructor
     */
    public Patient(){}

    /**
     * Gets patient's email
     * @return patient's email
     */
    public String getEmail(){
        return email;
    }

    /**
     * Sets patient's email
     * @param email new patient's email
     * @throws InvalidEmailFormatException thrown when invalid email
     */
    public void setEmail(String email) throws InvalidEmailFormatException {
        if (email == null) throw new NullPointerException("Email can be empty but cannot be null");
        if (email.isEmpty() || email.matches(PublicRegexes.emailRegex)){
            this.email = email;
        }
        else throw new InvalidEmailFormatException("Email can be empty or must have correct format");
    }
}