module javafx.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires model;
    requires controller;
    requires pubstuff;

    opens org.patient_registration_system.javafx_view to javafx.fxml;

    exports org.patient_registration_system.javafx_view;
}