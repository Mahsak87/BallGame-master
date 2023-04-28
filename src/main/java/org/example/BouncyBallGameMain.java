package org.example;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class BouncyBallGameMain {
    static Screen screen = new Screen();
    static Player player = new Player(screen);
    static Ball ball = new Ball(screen);

    public static void main(String[] args) throws IOException, InterruptedException {

        screen.border();
        long tick = 0;

        while (true) {
            KeyStroke keyStroke;
            do {
                //
                tick++;
                if (tick % ball.getTicks() == 0) {
                    ball.move();
                }
                keyStroke = screen.getKeyStroke();
                Thread.sleep(5);
            } while (keyStroke == null);
            switch (keyStroke.getKeyType()) {
                case ArrowLeft:
                    player.left();
                    break;
                case ArrowRight:
                    player.right();
                    break;
            }
        }

    }
}