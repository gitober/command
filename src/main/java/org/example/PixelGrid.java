package org.example;

public class PixelGrid {
    private int[][] grid = new int[8][8];
    private int cursorX = 0, cursorY = 0;

    // Simplified moveCursor method for relative movement
    public void moveCursor(int dx, int dy) {
        cursorX = Math.max(0, Math.min(7, cursorX + dx));
        cursorY = Math.max(0, Math.min(7, cursorY + dy));
    }

    public void togglePixel() {
        grid[cursorY][cursorX] ^= 1; // XOR to toggle pixel
    }

    public void generateJavaCode() {
        System.out.println("int[][] pixelArt = {");
        for (int[] row : grid) {
            System.out.print("    {");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + (i < row.length - 1 ? ", " : ""));
            }
            System.out.println("},");
        }
        System.out.println("};");
    }

    // Getters
    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public int[][] getGrid() {
        return grid;
    }
}
