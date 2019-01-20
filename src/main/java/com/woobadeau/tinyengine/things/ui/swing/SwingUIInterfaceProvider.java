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
    public Image resize(Image img, int newW, int newH) {
        java.awt.Image tmp = ((java.awt.Image) img).getScaledInstance(newW, newH, java.awt.Image.SCALE_SMOOTH);
        AWTImage result = new AWTImage(Math.abs(newW), newH, BufferedImage.TYPE_INT_ARGB);

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
    public Image getImage(String resource) throws IOException {
        return AWTImage.copyImage(ImageIO.read(SwingUIInterfaceProvider.class.getResourceAsStream(resource)));
    }

    @Override
    public Font getFont(String name, int style, int size) {
        return new AWTFont(name, style, size);
    }

    @Override
    public Color getRed() {
        return new AWTColor(java.awt.Color.RED.getRGB());
    }

    @Override
    public Color getGreen() {
        return new AWTColor(java.awt.Color.GREEN.getRGB());
    }

    @Override
    public Color getColor(int r, int g, int b) {
        return new AWTColor(r, g, b);
    }

}
