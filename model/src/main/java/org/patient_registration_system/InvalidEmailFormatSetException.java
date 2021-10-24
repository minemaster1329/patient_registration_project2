package org.patient_registration_system;

public class InvalidEmailFormatSetException extends Exception {
    public InvalidEmailFormatSetException(String error_message){
        super(error_message);
    }
}
