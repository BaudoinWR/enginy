package com.woobadeau.tinyengine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScrollingBackground extends Sprite {

    private int speed = 5;
    private boolean duplicated = false;

    ScrollingBackground(BufferedImage image, int zIndex) {
        super(image, zIndex);
        init();
    }

    public ScrollingBackground(String s, int zIndex) throws IOException {
        super(ImageIO.read(ScrollingBackground.class.getResourceAsStream(s)), zIndex);
        scale(1024, 640);
        init();
    }

    void init() {
        Movement movement = new Movement(this);
        speed = speed * zIndex;
        movement.speed = new Vector2D(-speed, 0);
        things.add(movement);
    }

    @Override
    protected void update() {
        int rightBorder = this.position.x + image.getWidth(null);
        if (!duplicated && rightBorder < TinyEngine.screen.getWidth() + speed) {
            ScrollingBackground scrollingBackground = new ScrollingBackground((BufferedImage) this.image, zIndex);
            scrollingBackground.position = new Vector2D(rightBorder, 0);
            duplicated = true;
        }

        if (rightBorder < 0) {
            this.destroy();
        }
    }


}
