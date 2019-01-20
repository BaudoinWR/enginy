package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.things.ui.Shape;

public class RectangularThing extends Thing {

    public RectangularThing(Shape shape) {
        this.setShape(shape);
    }

    @Override
    void updateShape() {
        Shape shape = this.getShape();
        shape.setFrame(getPosition().x, getPosition().y, shape.getWidth(), shape.getHeight());
    }
}
