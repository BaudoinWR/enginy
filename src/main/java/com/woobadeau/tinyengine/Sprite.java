package com.woobadeau.tinyengine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing implements ThingMouseListener {

    protected Image image;

    public Sprite(BufferedImage image) {
        super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
    }

    @Override
    void draw(Graphics graphics) {
        graphics.drawImage(image, position.x, position.y, Color.gray, TinyEngine.display);
    }

    @Override
    public void onClick() {
        System.out.println("Image clicked");
    }

}
