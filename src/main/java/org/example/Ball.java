package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Ball {
    private final char ball = '\u26BD';
    private Screen screen;

    int row;
    int col;
    int deltarow;
    int deltacol;
    int pointCounter = 0;


    public Ball(Screen screen) {
        this.screen = screen;
        //"Slumpmässig" startposition. Om ball börjar på
        // 12 så lyckas vi skapa en bugg - demo
        col = ThreadLocalRandom.current().nextInt(20, 60);
        row = ThreadLocalRandom.current().nextInt(2, 8);
        deltarow = 1;
        deltacol = 1;
        screen.putChar(col, row, ball);

    }

    public void move() {
        int nextrow = row + deltarow;
        int nextcol = col + deltacol;
        char idChar = screen.getChar(nextcol, nextrow);
        //Studslogiken för sidorna
        if (idChar == screen.getSides()) {
            deltacol *= -1;

        }
        //studslogiken för spelarens padel samt poängräkningen
        if (idChar == screen.getPlayerPadel()) {
            deltarow *= -1;
            pointCounter++;

        }
        //studslogiken för ovansidan
        if (idChar == screen.getTopSide()) {
            deltarow *= -1;
        }
        //logiken för botten, där spelet slutar och vi räknar ihop våra poäng.
        if (idChar == screen.getBottomRow()) {
            screen.putString(10, 12, "Game over. Score: " + pointCounter);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // ignore
            }
            System.exit(0);
        }
        screen.putChar(col, row, ' ');
        row += deltarow;
        col += deltacol;
        screen.putChar(col, row, ball);
    }

    public int getTicks() {
        //För varje gång bollen studsar mot spelarens padel går pointCounter upp med ett
        //vilket vi sedan använder i main för att öka tick-raten så spelet blir svårare och svårare
        return 30 - pointCounter;
    }
}
