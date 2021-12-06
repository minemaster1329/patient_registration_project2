package org.patient_registration_system.javafx_view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.patient_registration_system.javafx_view.models.Patient;

public class NewPatientViewController {
    private Patient newPatient = null;
    private Boolean cancelled = true;

    @FXML
    private Button cancelButton;

    @FXML
    private void confirmButtonAction(ActionEvent event){
        cancelled = false;
        newPatient = new Patient();
        closeWindow();
    }

    @FXML
    private void cancelButtonAction(ActionEvent event){
        closeWindow();
    }

    public Patient getNewPatient() {
        return newPatient;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    private void closeWindow(){
        Stage st = (Stage) cancelButton.getScene().getWindow();
        st.close();
    }
}
