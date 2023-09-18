package com.woobadeau.tinyengine.things;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class RectangularThing extends Thing {
    protected Shape shape;
    public RectangularThing(RectangularShape shape) {
        this.shape = shape;
    }

}
