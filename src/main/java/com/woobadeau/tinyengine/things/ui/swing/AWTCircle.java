package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Shape;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

class AWTCircle extends Ellipse2D.Float implements Shape {

    public AWTCircle(int x, int y, int i, int i1) {
        super(x, y, i, i1);
    }

    @Override
    public void setFrame(int x, int y, Number width, Number height) {
        this.setFrame(x, y, width.floatValue(), height.floatValue());
    }

    @Override
    public boolean intersects(Shape bounds) {
        return this.intersects(x, y, width, height);
    }

    @Override
    public boolean contains(int x, int y) {
        return this.contains((float) x, (float)y);
    }
}
