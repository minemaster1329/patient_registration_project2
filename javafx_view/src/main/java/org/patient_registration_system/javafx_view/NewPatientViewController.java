package org.patient_registration_system.javafx_view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;
import org.patient_registration_system.javafx_view.models.Gender;
import org.patient_registration_system.javafx_view.models.Patient;
import org.patient_registration_system.javafx_view.pubstuff.PublicRegexes;
import org.patient_registration_system.javafx_view.pubstuff.PublicStaticMethods;

public class NewPatientViewController {
    private Patient newPatient = null;
    private Boolean cancelled = true;
    private JavaFXErrorComminicationStrategy javaFXErrorComminicationStrategy;
    //<editor-fold desc="UI controls access objects">
    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField peselTextField;
    @FXML
    private TextField middleNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private ChoiceBox<Gender> genderChoiceBox;
    //</editor-fold>

    @FXML
    private void confirmButtonAction(ActionEvent event){
        boolean correctData = true;
        String temp = peselTextField.getText();
        Patient newPatient = new Patient();
        if (temp.matches(PublicRegexes.peselRegex)){
            if (PublicStaticMethods.validatePESELChecksum(temp)){
                try {
                    newPatient.setId(temp);
                }
                catch (Exception e) {
                    correctData = false;
                    javaFXErrorComminicationStrategy.writeError("Error when trying to set patient's PESEL", e.getMessage());
                }
            }
            else {
                correctData = false;
                javaFXErrorComminicationStrategy.writeError("New patient", "PESEL entered has incorrect checksum");
            }
        }
        else {
            correctData = false;
            javaFXErrorComminicationStrategy.writeError("New patient", "PESEL entered has incorrect format");
        }

        temp = firstNameTextField.getText();

        if (correctData && temp.matches(PublicRegexes.nameRegex)){
            System.out.println("XD");
            try {
                newPatient.setName(temp);
            }
            catch (Exception e){
                correctData = false;
                javaFXErrorComminicationStrategy.writeError("Error when trying to set patient's first name", e.getMessage());
            }
        }

        temp = surnameTextField.getText();

        if (correctData && temp.matches(PublicRegexes.nameRegex)){
            try {
                newPatient.setSurname(temp);
            }
            catch (Exception e){
                correctData = false;
                javaFXErrorComminicationStrategy.writeError("Error when trying to set patient's surname", e.getMessage());
            }
        }

        temp = middleNameTextField.getText();

        if (correctData && (temp.isEmpty() ||temp.matches(PublicRegexes.nameRegex))){
            try {
                newPatient.setMiddleName(temp);
            }
            catch (Exception e){
                correctData = false;
                javaFXErrorComminicationStrategy.writeError("Error when trying to set patient's middle name", e.getMessage());
            }
        }

        temp = emailTextField.getText();

        if (correctData && (temp.isEmpty() || temp.matches(PublicRegexes.emailRegex))){
            try {
                newPatient.setEmail(temp);
            }
            catch (Exception e){
                correctData = false;
                javaFXErrorComminicationStrategy.writeError("Error when trying to set patient's email", e.getMessage());
            }
        }

        Gender gdr = genderChoiceBox.getValue();

        if (correctData && gdr != null){
            try {
                newPatient.setGender(gdr);
            }
            catch (Exception e) {
                correctData = false;
                javaFXErrorComminicationStrategy.writeError("Error when setting patient's Gender", e.getMessage());
            }
        }

        if (correctData){
            cancelled = false;
            this.newPatient = newPatient;
            closeWindow();
        }
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
    @FXML
    public void initialize(){
        genderChoiceBox.getItems().setAll(Gender.values());
    }

    public NewPatientViewController(){
        javaFXErrorComminicationStrategy = new JavaFXErrorComminicationStrategy();
    }
}
