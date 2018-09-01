package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.*;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Scroll {
    private static final int DOTS = 10_000;
    public static void main(String[] args) throws IOException {
        new ScrollingBackground("/Hills__0000.png", 6);
        new ScrollingBackground("/Hills__0001.png", 4);
        new ScrollingBackground("/Hills__0002.png", 2);
        new ScrollingBackground("/Hills__0003.png", 1);
        new ScrollingBackground("/Hills__0004_Sky.png", 0);
        for (int i = 0; i < DOTS; i++) {
            new MovingDot(50,50,500,500);
        }
        new Sprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")), 10).scale(50,50);
        new Sprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")), 10).scale(50,50).move(new Vector2D(500,500));
        new Sprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")), 10).scale(50,50).move(new Vector2D(200,200));
        new Sprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")), 10).scale(50,50).move(new Vector2D(100,100));
        new Sprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")), 10).scale(50,50).move(new Vector2D(300,500));

        new TinyEngine(1024, 640);
    }
}
