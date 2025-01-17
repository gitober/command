package org.example;

public class TogglePixelCommand implements Command {
    private PixelGrid grid;

    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.togglePixel(); // Toggle the current pixel
    }
}