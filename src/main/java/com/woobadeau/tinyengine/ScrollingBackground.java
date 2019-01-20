package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.things.physics.Movement;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.Sprite;
import com.woobadeau.tinyengine.things.ui.Image;

public class ScrollingBackground extends Sprite {

    private int speed = 2;
    private boolean duplicated = false;

    public ScrollingBackground(Image image, int zIndex) {
        super(image, zIndex);
        init();
    }

    void init() {
        this.addBehavior(new Movement(new Vector2D(-speed, 0)));
    }

    @Override
    public void update() {
        int rightBorder = this.getPosition().x + getImage().getWidth();
        if (!duplicated && rightBorder < TinyEngine.width + speed) {
            ScrollingBackground scrollingBackground = new ScrollingBackground(this.getImage(), getZIndex());
            scrollingBackground.move(new Vector2D(rightBorder, 0));
            duplicated = true;
        }

        if (rightBorder < 0) {
            this.destroy();
        }
    }
}
