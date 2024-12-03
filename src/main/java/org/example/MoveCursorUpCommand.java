package org.example;

public class MoveCursorUpCommand implements Command {
    private PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor(0, -1); // Move up
    }
}