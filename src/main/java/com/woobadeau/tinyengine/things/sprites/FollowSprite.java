package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;

import java.awt.image.BufferedImage;

public class FollowSprite extends Sprite {
    public FollowSprite(BufferedImage image) {
        super(image, 0);
    }

    @Override
    public void update() {
        if (TinyEngine.mousePosition != null) {
            int x = TinyEngine.mousePosition.x - getImage().getWidth(null)/2;
            int y = TinyEngine.mousePosition.y - getImage().getHeight(null)/2;
            move(new Vector2D(x, y));
        }
    }
}
