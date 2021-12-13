package org.patient_registration_system.javafx_view;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;
import org.patient_registration_system.javafx_view.models.Patient;
import org.patient_registration_system.javafx_view.pubstuff.IErrorCommunicationStrategy;
import org.patient_registration_system.javafx_view.pubstuff.PublicRegexes;

import java.util.List;

/**
 * Controller class for PatientsView
 */
public class PatientsViewController {
    public ObservableList<Patient> getPatientsList() {
        return patientsList;
    }

    @FXML
    private final ObservableList<Patient> patientsList = FXCollections.observableArrayList();

    @FXML
    private TableView<Patient> patientsTableView;

    public PatientsViewController(){
        patientsList.addAll(PatientRegistrationSystemController.getAllPatients());
        patientsList.addListener((ListChangeListener<Patient>) change -> {
            change.next();
            if (change.wasAdded()){
                List<? extends Patient> added = change.getAddedSubList();
                for (Patient p : added){
                    PatientRegistrationSystemController.AddNewPatientToDb(p, new JavaFXErrorComminicationStrategy());
                }
            }

            if (change.wasRemoved()){
                List<? extends Patient> removed = change.getRemoved();
                for (Patient p : removed){
                    PatientRegistrationSystemController.DeletePatientWithSpecifiedID(p.getId(), new JavaFXErrorComminicationStrategy());
                }
            }
        });
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

            if (!ctrl.getCancelled()){
                patientsList.add(ctrl.getNewPatient());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void removePatientAction(ActionEvent event){
        if (!patientsTableView.getSelectionModel().getSelectedIndices().isEmpty()){
            for (Patient p : patientsTableView.getSelectionModel().getSelectedItems()){
                patientsList.removeIf((Patient pt) -> {
                    return pt.getId().equals(p.getId());
                });
            }
        }
    }

    @FXML
    private void editPatientsEmail(TableColumn.CellEditEvent<Patient, String> h){
        if (h.getNewValue().isEmpty() || h.getNewValue().matches(PublicRegexes.emailRegex)){
            try {
                h.getRowValue().setEmail(h.getNewValue());
            }
            catch (Exception e){
                JavaFXErrorComminicationStrategy str =  new JavaFXErrorComminicationStrategy();
                str.writeError("Error when editing email", e.getMessage());
            }
        }
    }
}
