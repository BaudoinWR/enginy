package com.woobadeau.tinyengine.things.physics;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ThingMouseListener;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class MovingDot extends Thing implements ThingMouseListener {
  Random rand = new Random();

  public MovingDot(int minX, int minY, int maxX, int maxY) {
    getThings().add(new RandomMovement(this));
    this.move(new Vector2D(rand.nextInt(50), rand.nextInt(50)));
    this.addBehavior(new ContainedBehavior(minX, minY, maxX, maxY));
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(Color.RED);
    graphics.drawOval(this.getPosition().x, this.getPosition().y, 5, 5);
  }

  @Override
  public void onClick() {
    System.out.println("clicked");
  }
}
 
