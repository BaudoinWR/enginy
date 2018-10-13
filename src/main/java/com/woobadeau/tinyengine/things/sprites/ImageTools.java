package com.woobadeau.tinyengine.things.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTools {
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {

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
}
