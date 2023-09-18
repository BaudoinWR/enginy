package com.woobadeau.tinyengine.behavior;
import com.woobadeau.tinyengine.things.Thing;

import com.woobadeau.tinyengine.things.physics.Vector2D;

public class ContainedBehavior implements Behavior {

  private final int minY;
  private final int minX;
  private final int maxY;
  private final int maxX;

  public ContainedBehavior(int minX, int minY, int maxX, int maxY) {
    this.minY = minY;
    this.minX = minX;
    this.maxY = maxY;
    this.maxX = maxX;
  }

  public void accept(Thing thing) {
    double x = thing.getPosition().x;
    double y = thing.getPosition().y;
    if (x > maxX) {
      x = maxX;
    }
    if (y > maxY) {
      y = maxY;
    }
    if (x < minX) {
      x = minX;
    }
    if (y < minY) {
      y = minY;
    }
    thing.moveTo(new Vector2D(x, y));
  }
}

