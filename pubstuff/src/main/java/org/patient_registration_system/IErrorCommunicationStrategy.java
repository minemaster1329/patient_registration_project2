package org.patient_registration_system;

/**
 * base interface for error comminucation strategies
 */
public interface IErrorCommunicationStrategy {
    /**
     * writes error the way user declared
     * @param caption error caption
     * @param message error message
     */
    void writeError(String caption, String message, Object... parameters);
}
