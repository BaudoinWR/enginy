package com.woobadeau.tinyengine.things.physics;


import com.woobadeau.tinyengine.things.physics.Bounded;

public interface Collider extends Bounded {

  void collides(Collider other);
}

