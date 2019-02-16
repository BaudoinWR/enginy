package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.things.physics.Movement;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.Sprite;
import com.woobadeau.tinyengine.things.ui.Image;

public class ScrollingBackground extends Sprite {

    private int speed;
    private boolean duplicated = false;

    public ScrollingBackground(Image image, Integer zIndex) {
        super(image, zIndex);
        speed = zIndex;
        init();
    }

    void init() {
        this.addBehavior(new Movement(new Vector2D(-speed, 0))::move);
    }

    @Override
    public void update() {
        int rightBorder = this.getPosition().x + getImage().getWidth();
        if (!duplicated && rightBorder < TinyEngine.width - speed) {
            TinyEngine.spawn(() -> new ScrollingBackground(getImage(), getZIndex()), bg -> bg.move(new Vector2D(rightBorder - speed, 0)));
            duplicated = true;
        }

        if (rightBorder < 0) {
            this.destroy();
        }
    }
}
