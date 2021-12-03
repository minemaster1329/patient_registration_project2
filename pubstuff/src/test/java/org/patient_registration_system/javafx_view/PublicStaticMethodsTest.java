package org.patient_registration_system.javafx_view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Nested;
import org.patient_registration_system.javafx_view.pubstuff.PublicStaticMethods;

import static org.junit.jupiter.api.Assertions.*;

class PublicStaticMethodsTest {
    @Nested
    class CanParseToIntTest{
        @ParameterizedTest
        @ValueSource(strings = {"", "xd", "0.0", ".0"})
        void canParseToIntInvalid(String input){
            Assertions.assertFalse(PublicStaticMethods.canParseToInt(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "11"})
        void canParseToIntValid(String input){
            assertTrue(PublicStaticMethods.canParseToInt(input));
        }
    }
}