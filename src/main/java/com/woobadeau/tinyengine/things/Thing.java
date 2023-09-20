package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.Collider;
import com.woobadeau.tinyengine.things.physics.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public abstract class Thing {
  private Vector2D position = new Vector2D(0,0);
  private int zIndex = 10;
  private Set<Thing> things = new HashSet<>();
  private boolean visible = true;
  private boolean active = true;
  private boolean collisionEnabled = false;

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
  }
  public final void drawThing(Graphics graphics) {
      draw(graphics);
      if (this instanceof Collider && TinyEngine.isDebug()) {
          graphics.setColor(Color.GREEN);
          ((Graphics2D)graphics).draw(((Collider) this).getCollidingZone());
      }
  }

  public void draw(Graphics graphics) {}
  public final void applyBehaviors() {
    getBehaviors().forEach(consumer -> consumer.accept(this));
  }

  public final void moveTo(Vector2D newPosition) {
    position = newPosition;
  }

  public final void move(Vector2D movement) {
    position = position.add(movement);
  }

  void updateShape() {

  }

  public Vector2D getPosition() {
    return position;
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

  public void setZIndex(int zIndex) {
    this.zIndex = zIndex;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public void collides(Thing thing) {}

  public boolean collisionEnabled() {
    return collisionEnabled;
  }

  public void onRemove() {
    behaviors.clear();
  }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
