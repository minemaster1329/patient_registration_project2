package org.patient_registration_system.javafx_view.models;

import org.patient_registration_system.javafx_view.exceptions.InvalidNameFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    Doctor dc;
    @BeforeEach
    void setUp() {
        dc = new Doctor();
    }

    @Nested
    class DoctorSetSpecializationNameTest{
        @Test
        void setSpecializationNameNull(){
            assertThrows(NullPointerException.class, ()->dc.setSpecializationName(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Spec1", "SPec", "1Spec", ""})
        void setSpecializationNameInvalid(String input){
            assertThrows(InvalidNameFormatException.class, ()-> dc.setSpecializationName(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Spec", "Sp", "Aaa"})
        void setSpecializationNameValid(String input){
            assertDoesNotThrow(()->dc.setSpecializationName(input));
        }
    }
}