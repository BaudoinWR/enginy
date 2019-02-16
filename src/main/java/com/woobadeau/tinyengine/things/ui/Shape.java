package com.woobadeau.tinyengine.things.ui;

import com.woobadeau.tinyengine.things.physics.Vector2D;

public interface Shape {
    double getX();

    double getY();

    double getWidth();

    double getHeight();

    void setFrame(int x, int y, Number width, Number height);

    boolean contains(int x, int y);

    default boolean contains(Vector2D position) {
        return this.contains(position.x, position.y);
    }

    boolean intersects(Shape shape);

    double getCenterX();

    double getCenterY();
}