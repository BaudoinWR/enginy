package com.woobadeau.tinyengine.things;

import java.awt.geom.RectangularShape;

public class RectangularThing extends Thing {

    public RectangularThing(RectangularShape shape) {
        this.setShape(shape);
    }

    @Override
    void updateShape() {
        RectangularShape shape = (RectangularShape) this.getShape();
        shape.setFrame(getPosition().x, getPosition().y, shape.getWidth(), shape.getHeight());
    }
}
