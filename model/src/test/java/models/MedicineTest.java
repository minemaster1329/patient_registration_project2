package models;

import com.google.inject.internal.util.Strings;
import exceptions.InvalidNameFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MedicineTest {
    Medicine md;
    @BeforeEach
    void init(){
        md = new Medicine();
    }

    @Nested
    class SetMedicineName{
        @Test
        void setMedicineNameNull(){
            assertThrows(NullPointerException.class, ()-> md.setName(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"2000Med", "InvMed", "invMed", "in2Med", "In2Med", " 2", "Med 2"})
        void setMedicineNameInvalid(String input){
            assertThrows(InvalidNameFormatException.class, ()->md.setName(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Med2000", "Med", "M2", "M"})
        void setMedicineNameValid(String input){
            assertDoesNotThrow(()->md.setName(input));
        }
    }

    @Nested
    class SetMedicineProducerName{
        @Test
        void setMedicineProducerNameNull(){
            assertThrows(NullPointerException.class, ()-> md.setProducerName(null));
        }

        @ParameterizedTest
        @ValueSource(strings = {"2000Med", "InvMed", "invMed", "in2Med", "In2Med", " 2", "Med 2", "Med2000", "M2", "M"})
        void setMedicineNameInvalid(String input){
            assertThrows(InvalidNameFormatException.class, ()->md.setProducerName(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"Med", "Valid"})
        void setMedicineNameValid(String input){
            assertDoesNotThrow(()->md.setProducerName(input));
        }
    }
}