package com.woobadeau.tinyengine;
public class Vector2D {
  final int x, y;

  public Vector2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vector2D add(Vector2D movement) {
    return new Vector2D(x + movement.x, y + movement.y);
  }
}
 
