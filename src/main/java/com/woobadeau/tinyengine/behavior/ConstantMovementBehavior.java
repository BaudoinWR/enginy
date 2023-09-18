package com.woobadeau.tinyengine.behavior;

import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.physics.Vector2D;

public class ConstantMovementBehavior implements Behavior {
  public Vector2D speed;

  public ConstantMovementBehavior(Vector2D speed) {
    this.speed = speed;
  }

  @Override
  public void accept(Thing o) {
    o.moveTo(o.getPosition().add(speed));
  }
}

