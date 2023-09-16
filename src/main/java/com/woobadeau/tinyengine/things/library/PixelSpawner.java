package com.woobadeau.tinyengine.things.library;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.behavior.ConstantMovementBehavior;
import com.woobadeau.tinyengine.behavior.DestroyOutOfScreenBehavior;
import com.woobadeau.tinyengine.things.Spawner;
import com.woobadeau.tinyengine.things.ThingMouseClickListener;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import java.awt.*;
import java.awt.geom.RectangularShape;

public class PixelSpawner extends Spawner {

    private final RectangularShape zone;

    public PixelSpawner(RectangularShape zone) {
        this.zone = zone;
    }

    @Override
    protected Pixel spawn() {
        int x = (int) (getPosition().x + zone.getWidth() * Math.random());
        int y = (int) (getPosition().y + zone.getHeight() * Math.random());
        //System.out.printf("Spawning pixel at %s, %s%n", x, y);
        Pixel pixel = new MouseListeningPixel(x, y);
        int speedX, speedY;
        Point middle = new Point(TinyEngine.width / 2, TinyEngine.height / 2);
        Vector2D direction = new Vector2D(x - middle.x, y - middle.y);
        if (direction.x == 0 && direction.y == 0) {
            direction = new Vector2D(Math.random() * 10, Math.random() * 10);
        }
        pixel.getBehaviors().add(new ConstantMovementBehavior(direction.normalize().times(5)));
        pixel.getBehaviors().add(new DestroyOutOfScreenBehavior());
        return pixel;
    }

    @Override
    protected int shouldSpawn() {
        return 3;
    }

    private class MouseListeningPixel extends Pixel implements ThingMouseClickListener {
        public MouseListeningPixel(int x, int y) {
            super(x, y, new Color(155,188,15));
        }

        @Override
        public void onClick() {
            System.out.println("clicked");
        }
    }
}
