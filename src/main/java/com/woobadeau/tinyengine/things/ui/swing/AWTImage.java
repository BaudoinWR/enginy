package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.lang.reflect.Field;
import java.util.Hashtable;

public class AWTImage implements Image {
    private BufferedImage image;

    public AWTImage(int width, int height, int imageType) {
        image = new BufferedImage(width, height, imageType);
    }


    public AWTImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public Image getSubImage(int x, int y, int width, int height) {
        BufferedImage subimage = image.getSubimage(x, y, width, height);
        return new AWTImage(subimage);
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getRGB(int x, int y) {
        return image.getRGB(x, y);
    }

    @Override
    public void setRGB(int x, int y, int rgb) {
        image.setRGB(x, y, rgb);
    }

    public BufferedImage getImage() {
        return image;
    }
}
