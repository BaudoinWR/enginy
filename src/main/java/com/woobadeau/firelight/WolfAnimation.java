package com.woobadeau.firelight;

import com.woobadeau.firelight.main.Firelight;
import com.woobadeau.tinyengine.AnimatedSprite;
import com.woobadeau.tinyengine.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WolfAnimation extends AnimatedSprite {
    public WolfAnimation() throws IOException {
        super(ImageIO.read(Firelight.class.getResourceAsStream("/wolfanim.png")), 4,6, 10);
        scale(100,100);
        move(new Vector2D(0,540));
        this.addBehavior(new ColorReplacer(this, new int[]{255,251,252}));
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
