module org.example.command {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    // Required JavaFX modules
    requires javafx.graphics;

    // Third-party dependencies
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    // For FXGL you might need to specify the module if you're using the modular version of FXGL
    requires com.almasb.fxgl.all;

    // Ensure the package is opened to javafx.fxml to allow FXML loading
    opens org.example.command to javafx.fxml, javafx.graphics;

    // Export the necessary packages if other modules or JavaFX components need to access them
    exports org.example to javafx.graphics;
}
