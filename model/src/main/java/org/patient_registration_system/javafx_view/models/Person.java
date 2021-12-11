package org.patient_registration_system.javafx_view.models;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.patient_registration_system.javafx_view.exceptions.InvalidIdFormatException;
import org.patient_registration_system.javafx_view.exceptions.InvalidMiddleNameFormatException;
import org.patient_registration_system.javafx_view.exceptions.InvalidNameFormatException;
import org.patient_registration_system.javafx_view.exceptions.InvalidSurnameFormatException;
import org.patient_registration_system.javafx_view.pubstuff.PublicRegexes;
import org.patient_registration_system.javafx_view.pubstuff.PublicStaticMethods;

/**
 * Superclass for all persons in database
 */
public class Person {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty surname;
    private final SimpleStringProperty middleName;
    private final SimpleObjectProperty<Gender> gender;

    /**
     * Default constructor for person class
     */
    protected Person() {
        id = new SimpleStringProperty("");
        name = new SimpleStringProperty("");
        surname = new SimpleStringProperty("");
        middleName = new SimpleStringProperty("");
        gender = new SimpleObjectProperty<Gender>(Gender.Unknown);
    }

    /**
     * Gets person's ID
     * @return person's ID
     */
    public String getId() {
        return id.get();
    }

    /**
     * Sets person's ID
     * @param id new person's ID (pattern rules the same as for PESEL number)
     * @throws NullPointerException thrown if given ID is null
     * @throws InvalidIdFormatException thrown when trying to set ID with invalid format
     */
    public void setId(String id) throws InvalidIdFormatException, NullPointerException {
        if (id == null) throw new NullPointerException("ID cannot be null");
        if (id.matches(PublicRegexes.peselRegex) && PublicStaticMethods.validatePESELChecksum(id)){
            this.id.set(id);
        }
        else throw new InvalidIdFormatException("Id must consist of 11 digits");
    }

    /**
     * Gets Person's name
     * @return person's name
     */
    public String getName() {
        return name.get();
    }

    /**
     * Sets person's name
     * @param name new person's name (must start from uppercase and can only contain english letters)
     * @throws InvalidNameFormatException thrown when trying to set name with invalid format
     * @throws NullPointerException thrown when supplied name is null
     */
    public void setName(String name) throws InvalidNameFormatException, NullPointerException {
        if (name == null) throw new NullPointerException("Name cannot be null");
        if (name.matches(PublicRegexes.nameRegex)){
            this.name.set(name);
        }

        else throw new InvalidNameFormatException("Name must start from uppercase and can only contain letters");
    }

    /**
     * Gets person's surname
     * @return person's surname
     */
    public String getSurname() {
        return surname.get();
    }

    /**
     * Sets person's surname
     * @param surname new person's surname (Must start from uppercase and can contain only english letters)
     * @throws NullPointerException thrown if supplied surname is null
     * @throws InvalidSurnameFormatException thrown if given surname has invalid format (Must start from uppercase and can contain only letters)
     */
    public void setSurname(String surname) throws NullPointerException, InvalidSurnameFormatException {
        if (surname == null) throw new NullPointerException("Surname cannot be null");
        if (surname.matches(PublicRegexes.nameRegex)){
            this.surname.set(surname);
        }
        else throw new InvalidSurnameFormatException("Surname must start from uppercase and can contain only english letters");
    }

    /**
     * Gets person's middle name
     * @return person's middle name
     */
    public String getMiddleName() {
        return middleName.get();
    }

    /**
     * Sets person's middle name
     * @param middleName new middle name (Can be empty. If not empty, must start from uppercase and can contain only letters)
     * @throws NullPointerException thrown if given middle name is null
     * @throws InvalidMiddleNameFormatException thrown if given middle name has invalid format (Middle name can be empty or must consist of letters and start with uppercase)
     */
    public void setMiddleName(String middleName) throws NullPointerException, InvalidMiddleNameFormatException {
        if (middleName == null) throw new NullPointerException("Surname can be empty but not null");
        if (middleName.isEmpty() || middleName.matches(PublicRegexes.nameRegex)){
            this.middleName.set(middleName);
        }
        else throw new InvalidMiddleNameFormatException("Middle name can be empty or can consist of letters only and start with uppercase");
    }

    /**
     * gets person gender
     * @return person's gender
     */
    public Gender getGender(){
        return gender.get();
    }

    /**
     * sets person gender
     * @param gender new person's gender
     */
    public void setGender(Gender gender){
        this.gender.set(gender);
    }
}
