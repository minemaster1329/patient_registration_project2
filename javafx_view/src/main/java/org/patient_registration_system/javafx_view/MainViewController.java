package org.patient_registration_system.javafx_view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller class for main view
 */
public class MainViewController {
    @FXML
    private Button showAllPatientsButton;

    /**
     * shows window with list of all patients
     * @param event reference to event
     */
    @FXML
    protected void onShowAllPatientsClick(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(JavaFXViewApp.class.getResource("patients-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Patient's list");
            stage.setScene(new Scene(fxmlLoader.load(), 640,450));
            stage.setResizable(false);
            stage.showAndWait();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
