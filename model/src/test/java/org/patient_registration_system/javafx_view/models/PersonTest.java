package org.patient_registration_system.javafx_view.models;

import org.patient_registration_system.javafx_view.exceptions.InvalidIdFormatException;
import org.patient_registration_system.javafx_view.exceptions.InvalidMiddleNameFormatException;
import org.patient_registration_system.javafx_view.exceptions.InvalidNameFormatException;
import org.patient_registration_system.javafx_view.exceptions.InvalidSurnameFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person ps = null;
    @BeforeEach
    void init() {ps = new Patient();}

    @Nested
    class SetIdTest{
        @Test
        void setIdNullTest(){
            assertThrows(NullPointerException.class, ()-> ps.setId(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1111111111A", "A1111111111", "XD", "AA11AA11AA1","12345678910"})
        void setIdInvalid(String input){
            assertThrows(InvalidIdFormatException.class, ()->ps.setId(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"97011454236","87082784745"})
        void setIdValid(String input){
            assertDoesNotThrow(()->ps.setId(input));
        }
    }

    @Nested
    class SetNameTest{
        @Test
        void setNameNullTest(){
            assertThrows(NullPointerException.class, ()->ps.setName(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"aaa", "A", "A1", "1A", "Aa1", "name"})
        void setNameInvalidValues(String input){
            assertThrows(InvalidNameFormatException.class, ()-> ps.setName(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Aa", "Name"})
        void setNameValidValues(String input){
            assertDoesNotThrow(()-> ps.setName(input));
        }
    }

    @Nested
    class SetSurnameTest{
        @Test
        void setSurnameNullTest(){
            assertThrows(NullPointerException.class, ()->ps.setSurname(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"aaa", "A", "A1", "1A", "Aa1", "name"})
        void setSurnameInvalidValues(String input){
            assertThrows(InvalidSurnameFormatException.class, ()-> ps.setSurname(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Aa", "Name"})
        void setSurnameValidValues(String input){
            assertDoesNotThrow(()-> ps.setSurname(input));
        }
    }

    @Nested
    class SetMiddleName {
        @Test
        void setMiddleNameNullTest(){
            assertThrows(NullPointerException.class, ()->ps.setMiddleName(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"aaa", "A", "A1", "1A", "Aa1", "name"})
        void setMiddleNameInvalidValues(String input){
            assertThrows(InvalidMiddleNameFormatException.class, ()-> ps.setMiddleName(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Aa", "Name", ""})
        void setMiddleNameValidValues(String input){
            assertDoesNotThrow(()-> ps.setMiddleName(input));
        }
    }
}