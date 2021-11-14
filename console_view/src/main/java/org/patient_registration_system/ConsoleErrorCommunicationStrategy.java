package org.patient_registration_system;

/**
 * Error communication strategy for console app
 */
public class ConsoleErrorCommunicationStrategy implements IErrorCommunicationStrategy {
    /**
     * Writes error message to console
     * @param caption error caption
     * @param message error message
     */
    @Override
    public void writeError(String caption, String message) {
        System.err.println(caption + " : "+message);
    }
}
