package com.woobadeau.tinyengine.things.physics;
public class Vector2D {
  public final double x, y;

  public Vector2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Vector2D add(Vector2D movement) {
    return new Vector2D(x + movement.x, y + movement.y);
  }
  public Vector2D times(int mult) {
    return new Vector2D(x * mult, y * mult);
  }

  public Vector2D normalize() {
    double length = Math.sqrt(x * x + y * y);
    return new Vector2D(x / length, y / length);
  }
}

