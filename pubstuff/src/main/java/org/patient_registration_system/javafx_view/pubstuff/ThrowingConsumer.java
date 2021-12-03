package org.patient_registration_system.javafx_view.pubstuff;

@FunctionalInterface
public interface ThrowingConsumer<T> {
    void apply(T t) throws Exception;
}
