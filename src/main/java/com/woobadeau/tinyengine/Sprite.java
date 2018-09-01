package com.woobadeau.tinyengine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing implements ThingMouseListener {

    protected Image image;

    public Sprite(BufferedImage image, int zIndex) {
        super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
        this.zIndex = zIndex;
    }

    protected static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    @Override
    protected void draw(Graphics graphics) {
        graphics.drawImage(image, position.x, position.y, null, TinyEngine.display);
    }

    @Override
    public void onClick() {
        System.out.println("Image clicked");
    }

    public Sprite scale(int newW, int newH) {
        image = resize((BufferedImage)image, newW, newH);
        this.shape = new Rectangle(0,0,image.getWidth(null), image.getHeight(null));
        return this;
    }
}
