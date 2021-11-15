package org.patient_registration_system;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Stores data about patient
 */
public class Patient {
    private Long id;
    private String name;
    private String surname;
    private String email;

    /**
     * default patient constructor
     */
    public Patient(){}

    /**
     * Sets patient's id
     * @param id new patient's id
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Gets patient's name
     * @return patient's name
     */
    public String getName(){
        return name;
    }

    /**
     * Gets patient's surname
     * @return patient's surname
     */
    public String getSurname(){
        return surname;
    }

    /**
     * Gets patient's email
     * @return patient's email
     */
    public String getEmail(){
        return email;
    }

    /**
     * Gets patient's ID number
     * @return patient's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets patient's name
     * @param name new patient's name
     * @throws InvalidNameFormatSetException thrown when name contains non-letter characters or not beginning from great letter
     * @throws NullPointerException throws when given string is null
     */
    public void setName(String name) throws InvalidNameFormatSetException, NullPointerException {
        if (name == null) throw new NullPointerException("Name cannot be null");
        Pattern pt = Pattern.compile("^[A-Z][a-z]+$");
        Matcher mt = pt.matcher(name);
        if (!mt.matches()) throw new InvalidNameFormatSetException("Name must start from great letter and can only contain letters");
        this.name = name;
    }

    /**
     * Sets patient's surname
     * @param surname new patient's surname
     * @throws InvalidNameFormatSetException thrown when name contains non-letter characters or not beginning from great letter
     * @throws NullPointerException thrown when given string is null
     */
    public void setSurname(String surname) throws InvalidNameFormatSetException {
        if (surname == null) throw new NullPointerException("Name cannot be null");
        Pattern pt = Pattern.compile("^[A-Z][a-z]+$");
        Matcher mt = pt.matcher(surname);
        if (!mt.matches()) throw new InvalidNameFormatSetException("Surame must start from great letter and can only contain letters");
        this.surname = surname;
    }

    /**
     * Sets patient's email
     * @param email new patient's email
     * @throws InvalidEmailFormatSetException thrown when invalid email
     */
    public void setEmail(String email) throws InvalidEmailFormatSetException {
        if (email != null){
            Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher mc = pattern.matcher(email);
            if (!mc.matches()) throw new InvalidEmailFormatSetException("Trying to set invalid email for patient "+this.id);
            email = email.toLowerCase(Locale.ROOT);
        }
        this.email = email;
    }
}
