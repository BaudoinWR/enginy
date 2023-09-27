package com.woobadeau.tinyengine.behavior;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.behavior.Behavior;
import com.woobadeau.tinyengine.things.Thing;

public class DestroyOutOfScreenBehavior implements Behavior {
  @Override
  public void accept(Thing thing) {
    if (thing.getPosition().x > TinyEngine.width || thing.getPosition().x < 0 || thing.getPosition().y > TinyEngine.width || thing.getPosition().y < 0) {
      thing.destroy();
    }
  }
}
