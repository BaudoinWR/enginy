package com.woobadeau.tinyengine.things.physics;


import com.woobadeau.tinyengine.things.Thing;

public interface Collider extends Bounded {

  void collides(Collider other);
}

