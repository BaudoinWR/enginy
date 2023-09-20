package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.RectangularThing;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing {

    protected Image image;
    private boolean xFlipped;

    protected Sprite(BufferedImage image, int zIndex) {
        super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
        this.setZIndex(zIndex);
    }

    @Override
    public void draw(Graphics graphics) {
        if (xFlipped) {
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            int x = (int) getPosition().x;
            int y = (int) getPosition().y;
            graphics.drawImage(image, x + width, y, -width, height, null);
        } else {
            graphics.drawImage(image, (int) (getPosition().x), (int) (getPosition().y), null);
        }
    }

    public Sprite scale(int newW, int newH) {
        image = ImageTools.resize((BufferedImage) getImage(), newW, newH);
        this.shape = (new Rectangle(shape.getBounds().x,shape.getBounds().y, getImage().getWidth(null), getImage().getHeight(null)));
        return this;
    }

    public Image getImage() {
        return image;
    }

    public boolean isxFlipped() {
        return xFlipped;
    }

    public void setxFlipped(boolean xFlipped) {
        this.xFlipped = xFlipped;
    }
}
