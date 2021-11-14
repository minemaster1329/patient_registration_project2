package org.patient_registration_system;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @ParameterizedTest(name = "{index} => a={0}, b={1}")
    @CsvSource({
            "invalid,0",
            "invalid@,0",
            "@,0",
            "@invalid,0",
            "@invalid.com,0",
            ",0",
            "invalid@invalid,0",
            "valid@valid.com,1",
            "valid123@valid.com,1",
            "123valid@valid.com,1"
    })
    void setEmail(String a, Integer b){
        switch (b){
            case 0:
                if (a != null){
                    Exception e = assertThrows(InvalidEmailFormatSetException.class, ()-> {
                        Patient pt = new Patient();
                        pt.setEmail(a);
                    });
                }
                break;
            case 1:
                assertDoesNotThrow(()->{
                    Patient pt = new Patient();
                    pt.setEmail(a);
                });
                break;
            default:
                fail("Invalid input");
                break;
        }
    }

    @Test
    void setId() {
    }

    @Test
    void getName() {
    }

    @Test
    void getSurname() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getId() {
    }

    @Test
    void setName() {
    }

    @Test
    void setSurname() {
    }

    @Test
    void testSetEmail() {
    }
}