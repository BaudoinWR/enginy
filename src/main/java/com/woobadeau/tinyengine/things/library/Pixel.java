package com.woobadeau.tinyengine.things.library;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.physics.Vector2D;

public class Pixel extends Thing {
    private final int color;

    public Pixel(int x, int y, int color) {
        this.color = color;
        this.moveTo(new Vector2D(x, y));
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        //SpriteBatch spriteBatch = TinyEngine.getSpriteBatch();
        Pixmap pixmap = new Pixmap( 1, 1, Pixmap.Format.RGB888);
        pixmap.setColor(color);
        pixmap.fill();

        //Pixmap pixmap = new Pixmap( 1, 1, Pixmap.Format.RGB888);
        //int colorRgba = com.badlogic.gdx.graphics.Color.rgba8888(224, 248, 208, 255);
        //pixmap.drawPixel(0, 0, colorRgba);
        //pixmap.drawPixel(1, 1, colorRgba);
        Texture pixmaptex = new Texture( pixmap );
        spriteBatch.draw(pixmaptex, (float) getPosition().x, (float) getPosition().y);
        pixmap.dispose();
        //graphics.setColor(color);
        //graphics.fillRect((int) this.getPosition().x, (int) this.getPosition().y, 1, 1);
    }
}
