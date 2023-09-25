package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.behavior.ConstantMovementBehavior;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScrollingBackground extends Sprite {

    private int speed = 2;
    private boolean duplicated = false;


    public ScrollingBackground(String s, int zIndex) throws IOException {
        super(s, zIndex);
        scale(1024, 640);
        init();
    }

    void init() {
        this.addBehavior(new ConstantMovementBehavior(new Vector2D(-speed, 0)));
    }

    @Override
    public void update() {
        int rightBorder = (int) (this.getPosition().x + getImage().getWidth());
        if (!duplicated && rightBorder < TinyEngine.screen.getWidth() + speed) {
            //ScrollingBackground scrollingBackground = new ScrollingBackground((BufferedImage) this.getImage(), getZIndex());
            //scrollingBackground.moveTo(new Vector2D(rightBorder, 0));
            duplicated = true;
        }

        if (rightBorder < 0) {
            this.destroy();
        }
    }
}
