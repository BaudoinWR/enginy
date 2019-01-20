package com.woobadeau.tinyengine.things.ui;

public abstract class UIInterfaceProvider {

    public abstract Display initDisplay(int width, int height);

    public abstract Shape getRectangle(int x, int y, int width, int height);

    public abstract Shape getCircle(int x, int y, int i, int i1);
}
