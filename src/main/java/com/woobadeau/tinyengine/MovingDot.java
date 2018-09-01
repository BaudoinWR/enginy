package com.woobadeau.tinyengine; /**
 * Paquet de définition
 **/

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class MovingDot extends Thing implements ThingMouseListener {
  Random rand = new Random();
  Movement movement;

  public MovingDot(int minX, int minY, int maxX, int maxY) {
    movement = new RandomMovement(this);
    this.position = new Vector2D(rand.nextInt(50), rand.nextInt(50));
    this.addBehavior(new ContainedBehavior(minX, minY, maxX, maxY));
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(Color.BLUE);
    graphics.drawOval(this.position.x, this.position.y, 5, 5);
  }

  @Override
  public void onClick() {
    System.out.println("clicked");
  }
}
 
