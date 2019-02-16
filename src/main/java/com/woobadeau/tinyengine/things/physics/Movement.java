package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.things.Thing;

import java.util.function.Consumer;

public class Movement {
  public Vector2D speed;

  public Movement(Vector2D speed) {
    this.speed = speed;
  }

  public void move(Thing o) {
    o.move(o.getPosition().add(speed));
  }
}
 
