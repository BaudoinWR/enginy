package com.woobadeau.tinyengine.things.ui;

public interface Shape {
    Integer getX();

    Integer getY();

    Shape getBounds();

    Number getWidth();

    Number getHeight();

    void setFrame(int x, int y, Number width, Number height);

    boolean intersects(Shape bounds);

    boolean contains(int x, int y);

    double getCenterX();

    double getCenterY();
}
