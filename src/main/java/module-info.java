module ipap.triangleareafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ipap.triangleareafx to javafx.fxml;
    exports ipap.triangleareafx;
}