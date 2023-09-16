package com.woobadeau;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.behavior.FollowBehavior;
import com.woobadeau.tinyengine.behavior.FollowMouseBehavior;
import com.woobadeau.tinyengine.things.RectangularThing;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.library.MovingDot;
import com.woobadeau.tinyengine.things.library.PixelSpawner;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.sprites.Sprite;
import com.woobadeau.tinyengine.things.sprites.SpriteFactory;
import java.awt.*;
import java.awt.geom.RectangularShape;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class Dotty {
    static {
        InputStream stream = Dotty.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public static void main(String[] args) throws IOException {
    new TinyEngine(160, 144, 5, () -> {}).start();
    Halo halo = new Halo(255, 155, 0, 100);
    MovingDot movingDot = new MovingDot(50, 50, 500, 500);
    halo.getBehaviors().add(new FollowBehavior(movingDot));
    new Halo(0,0,255,50, 10).getBehaviors().add(new FollowMouseBehavior());
    Sprite sprite = SpriteFactory.createSprite("/image.jpg");
    sprite.getBehaviors().add(new FollowMouseBehavior());
    new PixelSpawner(new Rectangle(20, 20)).move(new Vector2D(70, 62));
    new Thing() {
        @Override
        public void draw(Graphics graphics) {
            setZIndex(-1);
            graphics.setColor(new Color(15,56,15));
            graphics.fillRect((int) getPosition().x, (int) getPosition().y, 160, 144);
        }
        }.move(new Vector2D(0, 0));
    }

}