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

    @Nested
    class ValidatePESELChecksum{
        @ParameterizedTest
        @ValueSource(strings = {"97011454235",
                "87082784741",
                "05210423854",
                "79082535337",
                "02210229514",
                "92061056937",
                "03270842699",
                "72100531512",
                "85081799185",
                "51090382581"
        })
        void validatePESELChecksumInvalid(String input){
            assertFalse(PublicStaticMethods.validatePESELChecksum(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"97011454236",
                "87082784745",
                "05210423856",
                "79082535339",
                "02210229512",
                "92061056933",
                "03270842691",
                "72100531517",
                "85081799184",
                "51090382589"
        })
        void validatePESELChecksumValid(String input){
            assertTrue(PublicStaticMethods.validatePESELChecksum(input));
        }
    }
}