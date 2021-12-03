module model {
    requires jackson.databind;
    requires jackson.core;
    requires pubstuff;

    exports org.patient_registration_system.javafx_view.models;
    exports org.patient_registration_system.javafx_view.exceptions;
    exports org.patient_registration_system.javafx_view.database;
}