package org.patient_registration_system.javafx_view;

import javafx.scene.control.Alert;
import org.patient_registration_system.javafx_view.pubstuff.IErrorCommunicationStrategy;

public class JavaFXErrorComminicationStrategy implements IErrorCommunicationStrategy {
    @Override
    public void writeError(String caption, String message, Object... parameters) {
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle(caption);
        al.setContentText(message);
        al.show();
    }
}
