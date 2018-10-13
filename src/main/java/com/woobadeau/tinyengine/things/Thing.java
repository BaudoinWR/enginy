package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public abstract class Thing {
  private Vector2D position = new Vector2D(0,0);
  private Shape shape;
  private int zIndex = 10;
  private Set<Thing> things = new HashSet<>();
  private boolean visible = true;


  public Thing() {
    TinyEngine.register(this);
    onCreate();
  }

  private List<Consumer<Thing>> behaviors = new ArrayList<>();
  protected void addBehavior(Consumer<Thing> behavior) {
    this.getBehaviors().add(behavior);
  }
  protected void onCreate() {}
  public void beforeUpdate() {}
  public void update() {}
  public void afterUpdate() {}
  final public void destroy() {
    TinyEngine.remove(this);
    getThings().forEach(TinyEngine::remove);
    getThings().forEach(Thing::destroy);
    getThings().clear();
    behaviors.clear();
  }
  public void draw(Graphics graphics) {}
  public final void applyBehaviors() {
    getBehaviors().forEach(consumer -> consumer.accept(this));
  }

  public final void move(Vector2D newPosition) {
    position = newPosition;
    updateShape();
  }

  void updateShape() {

  }

  public Vector2D getPosition() {
    return position;
  }

  public Shape getShape() {
    return shape;
  }

  public int getZIndex() {
    return zIndex;
  }

  public Set<Thing> getThings() {
    return things;
  }

  public List<Consumer<Thing>> getBehaviors() {
    return behaviors;
  }

  protected void setShape(Shape shape) {
    this.shape = shape;
  }

  protected void setZIndex(int zIndex) {
    this.zIndex = zIndex;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }
}
 
