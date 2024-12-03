package org.example;

public class MoveCursorLeftCommand implements Command {
    private PixelGrid grid;

    public MoveCursorLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor(-1, 0); // Move left
    }
}