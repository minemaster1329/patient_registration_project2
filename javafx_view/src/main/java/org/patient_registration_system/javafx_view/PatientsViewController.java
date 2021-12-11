package org.patient_registration_system.javafx_view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;
import org.patient_registration_system.javafx_view.models.Patient;

/**
 * Controller class for PatientsView
 */
public class PatientsViewController {
    public ObservableList<Patient> getPatientsList() {
        return patientsList;
    }

    @FXML
    private final ObservableList<Patient> patientsList = FXCollections.observableArrayList();

    public PatientsViewController(){
        patientsList.addAll(PatientRegistrationSystemController.getAllPatients());
    }

    @FXML
    private void addNewPatientAction(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(JavaFXViewApp.class.getResource("new-patient-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Enter new patient's data:");
            stage.setScene(new Scene(fxmlLoader.load(), 640,320));
            stage.setResizable(false);
            stage.showAndWait();

            NewPatientViewController ctrl = fxmlLoader.getController();

            if (ctrl.getCancelled()){
                System.out.println("Operation cancelled");
            }
            else {
                System.out.println("Operation confirmed");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
