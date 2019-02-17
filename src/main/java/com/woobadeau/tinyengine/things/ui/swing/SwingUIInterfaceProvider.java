package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Color;
import com.woobadeau.tinyengine.things.ui.Font;
import com.woobadeau.tinyengine.things.ui.Image;
import com.woobadeau.tinyengine.things.ui.Shape;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.UIInterfaceProvider;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SwingUIInterfaceProvider implements UIInterfaceProvider {
    @Override
    public Display initDisplay(int width, int height) {
        return new SwingDisplay(width, height);
    }

    @Override
    public Shape getRectangle(int x, int y, int width, int height) {
        return new AWTRectangle(x, y, width, height);
    }

    @Override
    public Shape getCircle(int x, int y, int i, int i1) {
        return new AWTCircle(x, y, 100, 100);
    }

    @Override
    public Image resize(Image img, int newW, int newH){
        int type = ((AWTImage) img).getImage().getType() == 0? BufferedImage.TYPE_INT_ARGB : ((AWTImage) img).getImage().getType();
        BufferedImage resizedImage = new BufferedImage(Math.abs(newW), Math.abs(newH), type);
        Graphics2D g = resizedImage.createGraphics();
        if (newW < 0) {
            g.drawImage(((AWTImage) img).getImage(), -newW, 0, newW, newH, null);
        } else {
            g.drawImage(((AWTImage) img).getImage(), 0, 0, newW, newH, null);
        }
        g.dispose();

        return new AWTImage(resizedImage);
    }

    @Override
    public Image getImage(String resource) {
        try {
            return new AWTImage(ImageIO.read(SwingUIInterfaceProvider.class.getResourceAsStream(resource)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Font getFont(String name, int style, int size) {
        return new AWTFont(name, style, size);
    }

    @Override
    public Color getColor(int r, int g, int b) {
        return new AWTColor(r, g, b);
    }

}
