package com.woobadeau.tinyengine.things.ui;

public interface Shape {
    double getX();

    double getY();

    double getWidth();

    double getHeight();

    void setFrame(int x, int y, Number width, Number height);

    boolean contains(int x, int y);

    boolean intersects(Shape shape);

    double getCenterX();

    double getCenterY();
}