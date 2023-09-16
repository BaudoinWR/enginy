package com.woobadeau.tinyengine.things.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteFactory {
    SpriteFactory() {
        // not to be instantiated
    }
    public static Sprite createSprite(String resource) throws IOException {
        return new Sprite(getBufferedImage(resource), 0);
    }

    public static AnimatedSprite createAnimatedSprite(String resource, int rows, int columns) throws IOException {
        return new AnimatedSprite(getBufferedImage(resource), rows, columns, 0);
    }

    private static BufferedImage getBufferedImage(String resource) throws IOException {
        return ImageIO.read(SpriteFactory.class.getResourceAsStream(resource));
    }
}
