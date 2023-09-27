package com.woobadeau.tinyengine.things.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.libgdx.NestableFrameBuffer;
import com.woobadeau.tinyengine.things.sprites.AnimatedSprite;

public class SpriteFontText extends AnimatedSprite {
    private final String characters;

    SpriteFontText(String image) {
        this(image, 6, 7, "abcdefghijklmnopqrstuvwxyz0123456789!?.,;:");
    }

    protected SpriteFontText(String image, int rows, int cols, String characters) {
        super(image, rows, cols, 0);
        this.characters = characters;
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        //super.draw();
    }

    public Sprite getText(String text, int letterSpacing) {
        NestableFrameBuffer nestableFrameBuffer = new NestableFrameBuffer(Pixmap.Format.RGBA8888, TinyEngine.width, TinyEngine.height, false);
        nestableFrameBuffer.begin();
        SpriteBatch spriteBatch = TinyEngine.getSpriteBatch();
        spriteBatch.begin();
        ScreenUtils.clear(Color.CLEAR);
        for (int i = 0; i < text.length(); i++) {
            char c = text.toLowerCase().charAt(i);
            int index = characters.indexOf(c);
            if (index >= 0) {
                spriteBatch.draw(steps[index], i * (steps[0].getRegionWidth() + letterSpacing), 0);
            }
        }
        spriteBatch.end();
        nestableFrameBuffer.end();
        Texture texture = nestableFrameBuffer.getColorBufferTexture();
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        int width = (steps[0].getRegionWidth() + letterSpacing) * text.length();
        int height = steps[0].getRegionHeight();
        Sprite sprite = new Sprite(texture, width, height);
        sprite.flip(false, true);
        //sprite.setSize(sprite.getWidth(), sprite.getHeight());
        sprite.setPosition(20,20);
        return sprite;
    }
}
