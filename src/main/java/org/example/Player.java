package org.example;

public class Player {
    final int row = 22;
    int rightSide = 44;
    int leftSide = 36;
    final char player = '=';
    private Screen screen;

    public Player(Screen screen) {
        int colNew = leftSide;
        this.screen = screen;
        for (int i = colNew; i <= rightSide; i++) {
            screen.putChar(colNew + 1, row, player);
            colNew++;
        }

    }

    public void left() {
        if (leftSide > 1) {
            leftSide--;
            screen.putChar(leftSide, row, '=');
            screen.putChar(rightSide, row, ' ');
            rightSide--;
        }
    }

    public void right() {
        if (rightSide < 78) {
            rightSide++;
            screen.putChar(rightSide, row, '=');
            screen.putChar(leftSide, row, ' ');
            leftSide++;
        }
    }
}
