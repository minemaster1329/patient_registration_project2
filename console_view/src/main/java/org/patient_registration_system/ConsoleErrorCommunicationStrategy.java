package org.patient_registration_system;

public class ConsoleErrorCommunicationStrategy implements IErrorCommunicationStrategy {
    @Override
    public void writeError(String caption, String message) {
        System.err.println(caption + " : "+message);
    }
}
