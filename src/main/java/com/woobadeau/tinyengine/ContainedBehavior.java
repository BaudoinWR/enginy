package com.woobadeau.tinyengine;
import java.util.function.Consumer;

public class ContainedBehavior implements Consumer<Thing>{

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
    int x = thing.position.x;
    int y = thing.position.y;
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
 
