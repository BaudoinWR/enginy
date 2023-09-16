package com.woobadeau.tinyengine.things.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimatedSprite extends Sprite {
    BufferedImage[] steps;
    private int currentState = 0;

    AnimatedSprite(BufferedImage spriteSheet, int rows, int columns, int zIndex) {
        super(spriteSheet, zIndex);
        steps = split(spriteSheet, rows,columns);
        image = steps[0];
        setShape(new Rectangle(600,0, getImage().getWidth(null), getImage().getHeight(null)));
    }

    private BufferedImage[] split(BufferedImage spriteSheet, int rows, int columns) {
        BufferedImage[] bufferedImages = new BufferedImage[rows * columns];
        int width = spriteSheet.getWidth() / columns;
        int height = spriteSheet.getHeight() / rows;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bufferedImages[i*columns + j] = spriteSheet.getSubimage(j*width, i*height, width, height);
            }
        }
        return bufferedImages;
    }

    @Override
    public void update() {
        image = steps[currentState];
        currentState = (currentState+1) % steps.length;
    }

    @Override
    public Sprite scale(int newW, int newH) {
        for (int i = 0; i < steps.length; i++) {
            steps[i] = ImageTools.resize(steps[i], newW, newH);
        }
        return this;
    }
}
