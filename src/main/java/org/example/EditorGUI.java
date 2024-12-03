package org.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EditorGUI {
    private Stage stage;
    private PixelGrid grid;
    private Command upCommand, downCommand, leftCommand, rightCommand, toggleCommand, generateCodeCommand;

    public EditorGUI(Stage stage, PixelGrid grid) {
        this.stage = stage;
        this.grid = grid;
        setupCommands();
        setupUI();
    }

    private void setupCommands() {
        upCommand = new MoveCursorUpCommand(grid);
        downCommand = new MoveCursorDownCommand(grid);
        leftCommand = new MoveCursorLeftCommand(grid);
        rightCommand = new MoveCursorRightCommand(grid);
        toggleCommand = new TogglePixelCommand(grid);
        generateCodeCommand = new GenerateCodeCommand(grid);
    }

    private void setupUI() {
        GridPane pane = new GridPane();
        pane.setVgap(1); // Adds a vertical gap between rows
        pane.setHgap(1); // Adds a horizontal gap between columns

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(30, 30);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                final int finalX = x;
                final int finalY = y;
                rect.setOnMouseClicked(e -> {
                    // Ensure cursor movement logic is correct
                    grid.moveCursor(finalX, finalY); // Directly move the cursor to the clicked position
                    toggleCommand.execute();
                    updateGrid(pane);
                });
                pane.add(rect, x, y);
            }
        }

        Button btnGenerate = new Button("Generate Java Code");
        btnGenerate.setOnAction(e -> {
            generateCodeCommand.execute();
            updateGrid(pane); // Optional: Update grid if the state changes post-generation
        });
        pane.add(btnGenerate, 0, 8, 8, 1); // Ensure the button spans the entire bottom row

        Scene scene = new Scene(pane);
        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();
    }

    private void updateGrid(GridPane pane) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = (Rectangle) pane.getChildren().get(y * 8 + x);
                rect.setFill(grid.getGrid()[y][x] == 1 ? Color.BLACK : Color.WHITE);
            }
        }
    }
}
