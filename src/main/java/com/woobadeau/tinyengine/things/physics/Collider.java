package com.woobadeau.tinyengine.things.physics;


import com.woobadeau.tinyengine.things.Thing;

public interface Collider {

  void collides(Thing other);
}

