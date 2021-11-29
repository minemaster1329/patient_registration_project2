module com.example.javafx_view {
    requires javafx.controls;
    requires javafx.fxml;
            
                        
    opens com.example.javafx_view to javafx.fxml;
    exports com.example.javafx_view;
}