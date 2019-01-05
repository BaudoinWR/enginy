package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.things.Thing;

import java.util.function.Consumer;

public class Movement implements Consumer<Thing> {
  public Vector2D speed;

  public Movement(Vector2D speed) {
    this.speed = speed;
  }

  @Override
  public void accept(Thing o) {
    o.move(o.getPosition().add(speed));
  }
}
 
