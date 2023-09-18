package com.woobadeau.tinyengine.things.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteSheet extends AnimatedSprite {
    protected SpriteSheet(BufferedImage spriteSheet, int rows, int columns) {
        super(spriteSheet, rows, columns, 0);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics graphics) {
    }

    public BufferedImage getImage(int index) {
        return steps[index];
    }
}
