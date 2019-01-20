package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.things.physics.Movement;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.Sprite;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScrollingBackground extends Sprite {

    private int speed = 2;
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
        this.addBehavior(new Movement(new Vector2D(-speed, 0)));
    }

    @Override
    public void update() {
        int rightBorder = this.getPosition().x + getImage().getWidth(null);
        if (!duplicated && rightBorder < TinyEngine.width + speed) {
            ScrollingBackground scrollingBackground = new ScrollingBackground((BufferedImage) this.getImage(), getZIndex());
            scrollingBackground.move(new Vector2D(rightBorder, 0));
            duplicated = true;
        }

        if (rightBorder < 0) {
            this.destroy();
        }
    }
}
