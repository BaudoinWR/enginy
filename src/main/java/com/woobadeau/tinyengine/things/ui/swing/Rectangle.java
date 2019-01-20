package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Shape;

import java.awt.Point;

class Rectangle implements Shape {

    private final java.awt.Rectangle rect;

    Rectangle(int x, int y, int width, int height) {
        rect = new java.awt.Rectangle(x, y, width, height);
    }

    @Override
    public Integer getX() {
        return rect.x;
    }

    @Override
    public Integer getY() {
        return rect.y;
    }

    @Override
        public Shape getBounds() {
            return this;
        }

    @Override
    public Number getWidth() {
        return rect.width;
    }

    @Override
    public Number getHeight() {
        return rect.height;
    }

    @Override
    public void setFrame(int x, int y, Number width, Number height) {
        rect.setFrame(x, y, width.intValue(), height.intValue());
    }

    @Override
    public boolean intersects(Shape bounds) {
        return rect.intersects((java.awt.Rectangle) bounds);
    }

    @Override
    public boolean contains(int x, int y) {
        return rect.contains(new Point(x, y));
    }

    @Override
    public double getCenterX() {
        return rect.getCenterX();
    }

    @Override
    public double getCenterY() {
        return rect.getCenterY();
    }


}
