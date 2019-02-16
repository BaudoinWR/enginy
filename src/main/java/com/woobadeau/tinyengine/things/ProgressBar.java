package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ui.Color;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.Shape;

import java.util.function.Supplier;

public class ProgressBar extends RectangularThing {
    private final Color emptyColor;
    private final Color fullColor;
    private Supplier<Double> percentage;

    public ProgressBar(Shape shape, Color emptyColor, Color fullColor, Supplier<Double> percentage) {
        super(shape);
        this.emptyColor = emptyColor;
        this.fullColor = fullColor;
        this.percentage = percentage;
    }

    @Override
    public void draw(Display display) {
        Shape thisShape = getShape();
        Double percent = percentage.get();
        if (percent > 1) {
            percent = 1.0;
        }
        if (percent < 0) {
            percent = 0.0;
        }
        double width = thisShape.getWidth() * percent;
        Shape full = TinyEngine.uiInterfaceProvider.getRectangle(thisShape.getX(), thisShape.getY(), width, thisShape.getHeight());
        display.setColor(fullColor);
        display.fillRectangle(full);
        Shape empty = TinyEngine.uiInterfaceProvider.getRectangle(thisShape.getX() + width, thisShape.getY(), this.getShape().getWidth() - width, thisShape.getHeight());
        display.setColor(emptyColor);
        display.fillRectangle(empty);
    }
}
