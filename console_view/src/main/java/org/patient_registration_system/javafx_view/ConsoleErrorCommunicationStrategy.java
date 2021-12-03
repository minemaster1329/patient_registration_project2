package org.patient_registration_system.javafx_view;

import org.patient_registration_system.javafx_view.pubstuff.IErrorCommunicationStrategy;

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
    public void writeError(String caption, String message, Object... parameters) {
        System.err.println(caption + " : "+message);
    }
}
