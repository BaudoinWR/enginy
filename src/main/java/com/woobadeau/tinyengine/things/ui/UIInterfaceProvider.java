package com.woobadeau.tinyengine.things.ui;

import java.io.IOException;

public interface UIInterfaceProvider {

    Display initDisplay(int width, int height);

    Shape getRectangle(int x, int y, int width, int height);

    default Shape getRectangle(double x, double y, double width, double height){
        return getRectangle((int) x, (int) y, (int) width, (int) height);
    }

    Shape getCircle(int x, int y, int i, int i1);

    Image resize(Image img, int newW, int newH);

    Image getImage(String resource);

    Font getFont(String name, int style, int size);

    default Color getColorRed() {
        return getColor(255, 0, 0);
    }

    default Color getColorGreen() {
        return getColor(0, 255, 0);
    }

    default Color getColorBlue() {
        return getColor(0, 0, 255);
    }

    Color getColor(int r, int g, int b);

}
