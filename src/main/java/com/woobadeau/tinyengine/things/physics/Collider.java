package com.woobadeau.tinyengine.things.physics; 

import com.woobadeau.tinyengine.things.Thing;

public class Collider extends Thing {
  private final Thing object;

  public Collider(Thing object) {
    this.object = object;
  }

}

