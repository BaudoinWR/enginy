package com.woobadeau.tinyengine.things.physics;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ThingMouseClickListener;

import java.awt.*;
import java.util.Random;

public class MovingDot extends Thing implements ThingMouseClickListener {
  Random rand = new Random();

  public MovingDot(int minX, int minY, int maxX, int maxY) {
    this.move(new Vector2D(rand.nextInt(50), rand.nextInt(50)));
    this.addBehavior(new RandomMovement());
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
 
