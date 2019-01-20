package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.things.ui.Shape;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.UIInterfaceProvider;

public class SwingUIInterfaceProvider extends UIInterfaceProvider {
    @Override
    public Display initDisplay(int width, int height) {
        return new SwingDisplay(width, height);
    }

    @Override
    public Shape getRectangle(int x, int y, int width, int height) {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public Shape getCircle(int x, int y, int i, int i1) {
        return new Circle(x, y, 100, 100);
    }

}
