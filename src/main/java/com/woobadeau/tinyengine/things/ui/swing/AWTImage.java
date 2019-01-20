package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.lang.reflect.Field;
import java.util.Hashtable;

public class AWTImage extends BufferedImage implements Image {
    public AWTImage(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public AWTImage(int width, int height, int imageType, IndexColorModel cm) {
        super(width, height, imageType, cm);
    }

    public AWTImage(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
        super(cm, raster, isRasterPremultiplied, properties);
    }

    @Override
    public Image getSubImage(int x, int y, int width, int height) {
        BufferedImage subimage = getSubimage(x, y, width, height);
        return copyImage(subimage);
    }

    static Image copyImage(BufferedImage original) {
        ColorModel cm = original.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = original.copyData(original.getRaster());
        return new AWTImage(cm, raster, isAlphaPremultiplied, null);
    }
}
