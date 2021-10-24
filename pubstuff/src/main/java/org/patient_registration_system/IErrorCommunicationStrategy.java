package org.patient_registration_system;

public interface IErrorCommunicationStrategy {
    void writeError(String caption, String message);
}
