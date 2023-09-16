package com.woobadeau.tinyengine.behavior;

import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.physics.Vector2D;

public class RandomMovementBehavior extends ConstantMovementBehavior {

  private double max = 10;
  private double min = -10;

  public RandomMovementBehavior() {
    super(new Vector2D(0, 0));
  }

  @Override
  public void accept(Thing o) {
    speed = new Vector2D((int)getRandom(), (int)getRandom());
    super.accept(o);
  }

  private double getRandom() {
    return (Math.random() * ((max - min) + 1)) + min;
  }
}

