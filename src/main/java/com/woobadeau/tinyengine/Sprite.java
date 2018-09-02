package com.woobadeau.tinyengine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends RectangularThing {

    protected Image image;

    public Sprite(BufferedImage image, int zIndex) {
        super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
        this.image = image;
        this.zIndex = zIndex;
    }

    protected static BufferedImage resize(BufferedImage img, int newW, int newH) {

        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage result = new BufferedImage(Math.abs(newW), newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = result.createGraphics();
        if (newW < 0) {
            g2d.drawImage(tmp, -newW, 0, newW, newH,null);
        }
        else {
            g2d.drawImage(tmp, 0,0,null);
        }
        g2d.dispose();

        return result;
    }

    @Override
    protected void draw(Graphics graphics) {
        graphics.drawImage(image, position.x, position.y, null, TinyEngine.display);
    }

    public Sprite scale(int newW, int newH) {
        image = resize((BufferedImage)image, newW, newH);
        this.shape = new Rectangle(0,0,image.getWidth(null), image.getHeight(null));
        return this;
    }
}
