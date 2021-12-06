package org.patient_registration_system.javafx_view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.patient_registration_system.javafx_view.controller.PatientRegistrationSystemController;

import java.io.IOException;

public class JavaFXViewApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFXViewApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Patient's registration system v1.0");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        boolean initialization_succeeded =  PatientRegistrationSystemController.initializeModelSingleton(new JavaFXErrorComminicationStrategy());
        if (initialization_succeeded){
            launch();
        }
    }
}