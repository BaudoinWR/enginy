package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.ui.Image;

public class FollowSprite extends Sprite {
    public FollowSprite(Image image) {
        super(image, 0);
    }

    @Override
    public void update() {
        if (TinyEngine.mousePosition != null) {
            int x = TinyEngine.mousePosition.x - getImage().getWidth()/2;
            int y = TinyEngine.mousePosition.y - getImage().getHeight()/2;
            move(new Vector2D(x, y));
        }
    }
}
