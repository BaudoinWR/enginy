package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ui.Image;

public class AnimatedSprite extends Sprite {
    Image[] steps;
    private int currentState = 0;

    public AnimatedSprite(Image spriteSheet, int rows, int columns, int zIndex) {
        super(spriteSheet, zIndex);
        steps = split(spriteSheet, rows,columns);
        image = steps[0];
        setShape(TinyEngine.uiInterfaceProvider.getRectangle(600,0, image.getWidth(), image.getHeight()));
    }

    private Image[] split(Image spriteSheet, int rows, int columns) {
        Image[] bufferedImages = new Image[rows * columns];
        int width = spriteSheet.getWidth() / columns;
        int height = spriteSheet.getHeight() / rows;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bufferedImages[i*columns + j] = spriteSheet.getSubImage(j*width, i*height, width, height);
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
            steps[i] = TinyEngine.uiInterfaceProvider.resize(steps[i], newW, newH);
        }
        return this;
    }
}
