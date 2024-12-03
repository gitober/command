package org.example;

public class GenerateCodeCommand implements Command {
    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.generateJavaCode(); // Output the code representation of the grid
    }
}