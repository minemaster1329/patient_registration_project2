package org.patient_registration_system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
            assertDoesNotThrow(()-> {
                pt.setEmail(null);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"invalid", "invalid@", "@","@invalid", "@invalid.com"})
        void setEmailInvalidFormat(String email){
            assertThrows(InvalidEmailFormatSetException.class, ()->{
               pt.setEmail(email);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"valid@valid.com", "valid123@valid.com", "123valid@valid.com"})
        void setEmailValid(String email){
            assertDoesNotThrow(()->{
                pt.setEmail(email);
            });
        }
    }

    @Nested
    @DisplayName("setName test")
    class SetNameTest{
        @ParameterizedTest
        @ValueSource(strings = {"Mateusz", "Xd"})
        void setNameValidNamesTest(String name){
            assertDoesNotThrow(()->{
                pt.setName(name);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"mateusz", "xd", "1xxx", "M1teusz", "Mateus1"})
        void setNameInvalidNamesTest(String name){
            assertThrows(InvalidNameFormatSetException.class,()->{
                pt.setName(name);
            });
        }

        @Test
        void setNameNullNameTest(){
            assertThrows(NullPointerException.class,()->{
                pt.setName(null);
            });
        }
    }

    @Nested
    @DisplayName("setSurname test")
    class SetSurnameTest{
        @ParameterizedTest
        @ValueSource(strings = {"Mateusz", "Xd"})
        void setNameValidNamesTest(String name){
            assertDoesNotThrow(()->{
                pt.setSurname(name);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"mateusz", "xd", "1xxx", "M1teusz", "Mateus1"})
        void setNameInvalidNamesTest(String name){
            assertThrows(InvalidNameFormatSetException.class,()->{
                pt.setSurname(name);
            });
        }

        @Test
        void setNameNullNameTest(){
            assertThrows(NullPointerException.class,()->{
                pt.setSurname(null);
            });
        }
    }
}