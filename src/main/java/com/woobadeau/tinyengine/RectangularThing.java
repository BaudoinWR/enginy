package com.woobadeau.tinyengine;

import java.awt.geom.RectangularShape;

public class RectangularThing extends Thing {

    public RectangularThing(RectangularShape shape) {
        this.shape = shape;
    }

    @Override
    void updateShape() {
        RectangularShape shape = (RectangularShape) this.shape;
        shape.setFrame(position.x, position.y, shape.getWidth(), shape.getHeight());
    }
}
