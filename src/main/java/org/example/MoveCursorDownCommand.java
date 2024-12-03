package org.example;

public class MoveCursorDownCommand implements Command {
    private PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor(0, 1); // Move down
    }
}