package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.things.RectangularThing;
import com.woobadeau.tinyengine.TinyEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing {

    protected Image image;

    Sprite(BufferedImage image, int zIndex) {
        super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
        this.setZIndex(zIndex);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(getImage(), (int) (getPosition().x), (int) (getPosition().y), null, TinyEngine.display);
        if (TinyEngine.isDebug()) {
            graphics.setColor(Color.GREEN);
            ((Graphics2D)graphics).draw(getShape());
        }

    }

    public Sprite scale(int newW, int newH) {
        image = ImageTools.resize((BufferedImage) getImage(), newW, newH);
        this.setShape(new Rectangle(this.getShape().getBounds().x,this.getShape().getBounds().y, getImage().getWidth(null), getImage().getHeight(null)));
        return this;
    }

    public Image getImage() {
        return image;
    }
}
