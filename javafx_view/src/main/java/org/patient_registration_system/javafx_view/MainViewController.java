package org.patient_registration_system.javafx_view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;

public class MainViewController {
    @FXML
    private Button showAllPatientsButton;

    @FXML
    private Label patientsCountLabel;

    @FXML
    protected void onShowAllPatientsClick(){
        patientsCountLabel.setText(String.valueOf(PatientRegistrationSystemController.getAllPatients().size()));
    }
}
