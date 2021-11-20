package org.patient_registration_system;

@FunctionalInterface
public interface ThrowingConsumer<T> {
    void apply(T t) throws Exception;
}
