package org.patient_registration_system;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;

class PublicStaticMethodsTest {

    @ParameterizedTest(name = "{index} => a={0}, b={1}")
    @CsvSource({
            "1,1",
            "11,1",
            ",0",
            "xd,0",
            "0.0,0",
            ".0,0"
    })
    void canParseToInt(String a, Integer b) {
        switch(b){
            case 0:
                assertFalse(PublicStaticMethods.canParseToInt((a)));
                break;
            case 1:
                assertTrue(PublicStaticMethods.canParseToInt(a));
                break;
            default:
                fail("Invalid option");
                break;
        }
    }
}