package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Shape;

import java.awt.Point;
import java.awt.Rectangle;

class AWTRectangle extends Rectangle implements Shape {

    public AWTRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void setFrame(int x, int y, Number width, Number height) {
        this.setFrame(x, y, width.floatValue(), height.doubleValue());
    }

    @Override
    public boolean intersects(Shape shape) {
        return this.intersects(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }
}
