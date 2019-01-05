package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.things.Thing;

public class Movement extends Thing {
  public Vector2D speed = new Vector2D(0,0);
  Thing object;

  public Movement(Thing object) {
    this.object = object;
  }

  @Override
  public int getZIndex() {
    return -1;
  }

  @Override
  public void update() {
    object.move(object.getPosition().add(speed));
  }
}
 
