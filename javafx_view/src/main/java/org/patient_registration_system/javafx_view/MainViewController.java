package org.patient_registration_system.javafx_view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;

public class MainViewController {
    @FXML
    private Button showAllPatientsButton;

    @FXML
    private Label patientsCountLabel;

    @FXML
    protected void onShowAllPatientsClick(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(JavaFXViewApp.class.getResource("patients-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Patient's list");
            stage.setScene(new Scene(fxmlLoader.load(), 450,450));
            stage.showAndWait();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
