package com.woobadeau.tinyengine.things.library;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import java.awt.*;

public class Pixel extends Thing {
    private final Color color;

    public Pixel(int x, int y, Color color) {
        this.color = color;
        this.setShape(new Rectangle(x, y, 1, 1));
        this.move(new Vector2D(x, y));
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int) this.getPosition().x, (int) this.getPosition().y, 1, 1);
    }
}
