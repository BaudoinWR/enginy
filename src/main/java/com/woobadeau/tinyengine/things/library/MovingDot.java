package com.woobadeau.tinyengine.things.library;
import com.woobadeau.tinyengine.behavior.ContainedBehavior;
import com.woobadeau.tinyengine.behavior.RandomMovementBehavior;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ThingMouseClickListener;

import com.woobadeau.tinyengine.things.physics.Vector2D;
import java.awt.*;
import java.util.Random;

public class MovingDot extends Thing implements ThingMouseClickListener {
  Random rand = new Random();

  public MovingDot(int minX, int minY, int maxX, int maxY) {
    this.move(new Vector2D(rand.nextInt(50), rand.nextInt(50)));
    this.addBehavior(new RandomMovementBehavior());
    this.addBehavior(new ContainedBehavior(minX, minY, maxX, maxY));
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(Color.RED);
    graphics.drawOval((int) this.getPosition().x, (int) this.getPosition().y, 5, 5);
  }

  @Override
  public void onClick() {
    System.out.println("clicked");
  }
}

