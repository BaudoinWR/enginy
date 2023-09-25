package com.woobadeau.tinyengine.things.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet extends AnimatedSprite {
    protected SpriteSheet(String spriteSheet, int rows, int columns) {
        super(spriteSheet, rows, columns, 0);
    }

    @Override
    public void update() {
    }


    public TextureRegion getSubImage(int index) {
        return steps[index];
    }
}
