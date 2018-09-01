package com.woobadeau.tinyengine;

import java.awt.image.BufferedImage;

public class FollowSprite extends Sprite {
    public FollowSprite(BufferedImage image) {
        super(image, 0);
    }

    @Override
    protected void update() {
        if (TinyEngine.mousePosition != null) {
            int x = TinyEngine.mousePosition.x - image.getWidth(null)/2;
            int y = TinyEngine.mousePosition.y - image.getHeight(null)/2;
            move(new Vector2D(x, y));
        }
    }
}
