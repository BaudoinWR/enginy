package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Shape;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

class Circle implements Shape {

    private final Ellipse2D.Float circle;

    Circle(int x, int y, int i, int i1) {
        circle = new Ellipse2D.Float(x, y, 100, 100);
    }

    @Override
    public Integer getX() {
        return (int) circle.x;
    }

    @Override
    public Integer getY() {
        return (int) circle.y;
    }

    @Override
    public Shape getBounds() {
        return new Rectangle((int) circle.x, (int) circle.y,(int) circle.width,(int) circle.height);
    }

    @Override
    public Number getWidth() {
        return circle.width;
    }

    @Override
    public Number getHeight() {
        return circle.height;
    }

    @Override
    public void setFrame(int x, int y, Number width, Number height) {
        circle.setFrame(x, y, width.floatValue(), height.floatValue());
    }

    @Override
    public boolean intersects(Shape bounds) {
        return circle.intersects((Rectangle2D) bounds);
    }

    @Override
    public boolean contains(int x, int y) {
        return circle.contains(new Point(x, y));
    }

    @Override
    public double getCenterX() {
        return circle.getCenterX();
    }

    @Override
    public double getCenterY() {
        return circle.getCenterY();
    }
}
