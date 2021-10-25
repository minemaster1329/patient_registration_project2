package org.patient_registration_system;

/**
 * Error communication strategy for console app
 */
public class ConsoleErrorCommunicationStrategy implements IErrorCommunicationStrategy {
    @Override
    public void writeError(String caption, String message) {
        System.err.println(caption + " : "+message);
    }
}
