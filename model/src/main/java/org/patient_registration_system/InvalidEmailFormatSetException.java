package org.patient_registration_system;

/**
 * Exception for invalid email
 */
public class InvalidEmailFormatSetException extends Exception {
    /**
     * parametrized constructor for exception
     * @param error_message exception message1
     */
    public InvalidEmailFormatSetException(String error_message){
        super(error_message);
    }
}
