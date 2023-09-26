package com.woobadeau.tinyengine.things.sprites;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet extends AnimatedSprite {
    protected SpriteSheet(String spriteSheet, int rows, int columns) {
        super(spriteSheet, rows, columns, 0);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
    }

    public TextureRegion getSubImage(int index) {
        return steps[index];
    }
}
