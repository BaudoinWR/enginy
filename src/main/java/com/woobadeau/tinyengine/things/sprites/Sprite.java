package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.things.RectangularThing;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ui.Display;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing {

    protected Image image;

    public Sprite(BufferedImage image, int zIndex) {
        super(TinyEngine.uiInterfaceProvider.getRectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
        this.setZIndex(zIndex);
    }

    @Override
    public void draw(Display display) {
        display.drawImage(getImage(), getPosition().x, getPosition().y, TinyEngine.display);
        if (TinyEngine.isDebug()) {
            display.setColor(display.getGreen());
            display.draw(getShape());
        }

    }

    public Sprite scale(int newW, int newH) {
        image = ImageTools.resize((BufferedImage) getImage(), newW, newH);
        this.setShape(TinyEngine.uiInterfaceProvider.getRectangle(this.getShape().getBounds().getX(),this.getShape().getBounds().getY(), getImage().getWidth(null), getImage().getHeight(null)));
        return this;
    }

    public Image getImage() {
        return image;
    }
}
