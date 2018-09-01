package com.woobadeau.tinyengine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public abstract class Thing {
  protected Vector2D position = new Vector2D(0,0);
  Shape shape;
  protected int zIndex = 10;
  Set<Thing> things = new HashSet<>();

  public Thing() {
    TinyEngine.register(this);
    onCreate();
  }

  private List<Consumer<Thing>> behaviors = new ArrayList<>();
  protected void addBehavior(Consumer<Thing> behavior) {
    this.behaviors.add(behavior);
  }
  int getZIndex() { return zIndex; }
  protected void onCreate() {}
  protected void beforeUpdate() {}
  protected void update() {}
  protected void afterUpdate() {}
  final  void destroy() {
    TinyEngine.remove(this);
    things.forEach(TinyEngine::remove);
    things.forEach(Thing::destroy);
  }
  protected void draw(Graphics graphics) {}
  final void applyBehaviors() {
    behaviors.forEach(consumer -> consumer.accept(this));
  }

  public final void move(Vector2D newPosition) {
    position = newPosition;
    updateShape();
  }

  void updateShape() {}
}
 
