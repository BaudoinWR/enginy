package com.woobadeau.tinyengine.things.physics;
import com.woobadeau.tinyengine.things.Thing;

import java.util.function.Consumer;

public class ContainedBehavior {

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

  public void contain(Thing thing) {
    int x = thing.getPosition().x;
    int y = thing.getPosition().y;
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
    thing.move(new Vector2D(x, y));
  }
}
 
