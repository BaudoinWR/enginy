package com.woobadeau.firelight;

import com.woobadeau.tinyengine.Sprite;
import com.woobadeau.tinyengine.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class LightbugSprite extends Sprite {
    private boolean draw = false;
    private int wavelength;

    private final Random random = new Random();

    public LightbugSprite() throws IOException {
        super(ImageIO.read(LightbugSprite.class.getResourceAsStream("/lightbug.png")), 10);
        move(new Vector2D(random.nextInt(1000), random.nextInt(580)));
        wavelength = random.nextInt(400) + 380;
        System.out.println(wavelength);
        int[] rgb = ColorManager.getRgb(wavelength);
        setupColor(rgb);
        scale(-50,50);

        draw = true;
    }

    @Override
    protected void draw(Graphics graphics) {
        if (draw) {
            super.draw(graphics);
        }
    }

    @Override
    protected void update() {
        if (Math.abs(ColorManager.wavelength - wavelength) < 10) {
            System.out.println("FOUND");
        }
    }

    public void setupColor(int[] color) {
        int col = ColorManager.rgbToInt(color);
        for (int i = 0; i < image.getWidth(null); i++)
            for (int j = 0; j < image.getHeight(null); j++) {
                int rgb = ((BufferedImage) image).getRGB(i, j);
                if (rgb == ColorManager.pinkRGB) {
                    ((BufferedImage) image).setRGB(i,j, col);
                }
            }
    }

}
