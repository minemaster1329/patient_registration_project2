package org.patient_registration_system.javafx_view.models;

import org.patient_registration_system.javafx_view.exceptions.InvalidEmailFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {
    Patient pt = null;
    @BeforeEach
    void init(){
        pt = new Patient();
    }

    @Nested
    class SetEmailTest{
        @Test
        void setEmailInvalidNull(){
            assertThrows(NullPointerException.class, ()->pt.setEmail(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"invalid", "invalid@", "@","@invalid", "@invalid.com"})
        void setEmailInvalidFormat(String email){
            assertThrows(InvalidEmailFormatException.class, ()->pt.setEmail(email));
        }

        @ParameterizedTest
        @ValueSource(strings = {"valid@valid.com", "valid123@valid.com", "123valid@valid.com", ""})
        void setEmailValid(String email){
            assertDoesNotThrow(()->pt.setEmail(email));
        }
    }
}