package org.patient_registration_system;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @org.junit.jupiter.api.Test
    void setEmail() {
        Exception e = assertThrows(InvalidEmailFormatSetException.class, ()-> {
           Patient pt = new Patient("", "", "");
           pt.setEmail("invalid");
        });

        e = assertThrows(InvalidEmailFormatSetException.class, ()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("invalid@");
        });
        e = assertThrows(InvalidEmailFormatSetException.class, ()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("@");
        });

        e = assertThrows(InvalidEmailFormatSetException.class, ()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("@invalid");
        });

        e = assertThrows(InvalidEmailFormatSetException.class, ()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("invalid");
        });

        assertDoesNotThrow(()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("domain@comain.com");
        });

        assertDoesNotThrow(()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("123domain@comain.com");
        });

        assertDoesNotThrow(()-> {
            Patient pt = new Patient("", "", "");
            pt.setEmail("domain@comain1.com");
        });
    }
}