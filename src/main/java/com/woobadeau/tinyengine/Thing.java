package com.woobadeau.tinyengine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

abstract class Thing {
  Vector2D position = new Vector2D(0,0);
  Shape shape;

  Thing() {
    TinyEngine.register(this);
    onCreate();
  }
  
  private List<Consumer<Thing>> behaviors = new ArrayList<>();
  void addBehavior(Consumer<Thing> behavior) {
    this.behaviors.add(behavior);
  }
  int getZIndex() { return 0; }
  void onCreate() {}
  void beforeUpdate() {}
  void update() {}
  void afterUpdate() {}
  void onDestroy() {}
  void draw(Graphics graphics) {}
  final void applyBehaviors() {
    behaviors.forEach(consumer -> consumer.accept(this));
  }

  final void move(Vector2D newPosition) {
    position = newPosition;
    updateShape();
  }

  void updateShape() {}
}
 
