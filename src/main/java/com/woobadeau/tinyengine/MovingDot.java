package com.woobadeau.tinyengine;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Random;

public class MovingDot extends Thing implements ThingMouseListener {
  Random rand = new Random();

  public MovingDot(int minX, int minY, int maxX, int maxY) {
    things.add(new RandomMovement(this));
    this.position = new Vector2D(rand.nextInt(50), rand.nextInt(50));
    this.addBehavior(new ContainedBehavior(minX, minY, maxX, maxY));
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(Color.RED);
    graphics.drawOval(this.position.x, this.position.y, 5, 5);
  }

  @Override
  public void onClick() {
    System.out.println("clicked");
  }
}
 
