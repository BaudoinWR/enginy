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

    Color getRed();

    Color getGreen();

    Color getColor(int r, int g, int b);

}
