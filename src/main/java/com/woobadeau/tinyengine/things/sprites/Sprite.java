package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.things.RectangularThing;
import com.woobadeau.tinyengine.TinyEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing {

    protected Image image;

    public Sprite(BufferedImage image, int zIndex) {
        super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
        this.setZIndex(zIndex);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(getImage(), getPosition().x, getPosition().y, null, TinyEngine.display);
    }

    public Sprite scale(int newW, int newH) {
        image = ImageTools.resize((BufferedImage) getImage(), newW, newH);
        this.setShape(new Rectangle(0,0, getImage().getWidth(null), getImage().getHeight(null)));
        return this;
    }

    public Image getImage() {
        return image;
    }
}
