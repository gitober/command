package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class PixelArtEditorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        PixelGrid grid = new PixelGrid();
        new EditorGUI(primaryStage, grid);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
