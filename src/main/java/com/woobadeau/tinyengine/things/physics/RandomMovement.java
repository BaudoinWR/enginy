package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.things.Thing;

public class RandomMovement extends Movement {

  private double max = 10;
  private double min = -10;

  public RandomMovement() {
    super(new Vector2D(0, 0));
  }

  public void move(Thing o) {
    speed = new Vector2D((int)getRandom(), (int)getRandom());
    super.move(o);
  }

  private double getRandom() {
    return (Math.random() * ((max - min) + 1)) + min;
  }
}
 
