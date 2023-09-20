package com.woobadeau.tinyengine.things.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteFontText extends AnimatedSprite {
    private final String characters;

    SpriteFontText(BufferedImage image) {
        this(image, 6, 7, "abcdefghijklmnopqrstuvwxyz0123456789!?.,;:");
    }

    protected SpriteFontText(BufferedImage image, int rows, int cols, String characters) {
        super(image, rows, cols, 0);
        this.characters = characters;
    }

    @Override
    public void draw(Graphics graphics) {
    }

    public BufferedImage getText(String text, int letterSpacing) {
        BufferedImage bufferedImage = new BufferedImage((steps[0].getWidth() + letterSpacing) * text.length(), steps[0].getHeight(), steps[0].getType());
        bufferedImage.getGraphics();
        for (int i = 0; i < text.length(); i++) {
            char c = text.toLowerCase().charAt(i);
            int index = characters.indexOf(c);
            if (index >= 0) {
                bufferedImage.getGraphics().drawImage(steps[index], i * (steps[0].getWidth() + letterSpacing), 0, null);
            }
        }
        return bufferedImage;
    }
}
