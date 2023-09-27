package com.woobadeau.tinyengine.things.sprites;


import com.woobadeau.tinyengine.things.sprites.AnimatedSprite;
import com.woobadeau.tinyengine.things.sprites.Sprite;
import com.woobadeau.tinyengine.things.sprites.SpriteFontText;
import com.woobadeau.tinyengine.things.sprites.SpriteSheet;

public class SpriteFactory {
    SpriteFactory() {
        // not to be instantiated
    }
    public static Sprite createSprite(String resource) {
        return new Sprite(resource, 0);
    }

    /*public static Sprite createSprite(BufferedImage image) {
        return new Sprite(image, 0);
    }*/

    public static AnimatedSprite createAnimatedSprite(String resource, int rows, int columns)  {
        return new AnimatedSprite(resource, rows, columns, 0);
    }

    public static SpriteSheet createSpriteSheet(String resource, int rows, int columns)  {
        return new SpriteSheet(resource, rows, columns);
    }

    public static SpriteFontText createSpriteFontText(String resource)  {
        return new SpriteFontText(resource);
    }

    public static SpriteFontText createSpriteFontText(String resource, int rows, int clos, String characters)  {
        return new SpriteFontText(resource, rows, clos, characters);
    }

}
