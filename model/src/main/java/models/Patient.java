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
        if (email != null){
            Pattern pattern = Pattern.compile(PublicRegexes.emailRegex, Pattern.CASE_INSENSITIVE);
            Matcher mc = pattern.matcher(email);
            if (!mc.matches()) throw new InvalidEmailFormatException("Trying to set invalid email for patient "+this.getId());
            email = email.toLowerCase(Locale.ROOT);
        }
        this.email = email;
    }
}
