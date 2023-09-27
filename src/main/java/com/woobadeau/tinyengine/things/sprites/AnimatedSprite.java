package com.woobadeau.tinyengine.things.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.woobadeau.tinyengine.things.sprites.Sprite;

public class AnimatedSprite extends Sprite {
    protected TextureRegion[] steps;
    private int currentState = 0;

    protected AnimatedSprite(String spriteSheet, int rows, int columns, int zIndex) {
        super(spriteSheet, zIndex);
        steps = split(image, rows,columns);
        image = steps[0].getTexture();
    }

    private TextureRegion[] split(Texture spriteSheet, int rows, int columns) {
        TextureRegion[] textureRegions = new TextureRegion[rows * columns];
        int width = spriteSheet.getWidth() / columns;
        int height = spriteSheet.getHeight() / rows;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                textureRegions[i*columns + j] = new TextureRegion(spriteSheet, j*width, i*height, width, height);
            }
        }
        return textureRegions;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        if (isxFlipped()) {
            spriteBatch.draw(steps[currentState], (int) getPosition().x + steps[currentState].getRegionWidth(), (int) getPosition().y, -steps[currentState].getRegionWidth(), steps[currentState].getRegionHeight());
        } else {
            spriteBatch.draw(steps[currentState], (int) getPosition().x, (int) getPosition().y);
        }

    }

    public void setState(int state) {
        currentState = state;
    }
}
