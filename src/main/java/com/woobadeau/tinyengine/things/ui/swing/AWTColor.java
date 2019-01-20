package com.woobadeau.tinyengine.things.ui.swing;

import java.awt.Color;
import java.awt.color.ColorSpace;

public class AWTColor extends Color implements com.woobadeau.tinyengine.things.ui.Color {
    public AWTColor(int r, int g, int b) {
        super(r, g, b);
    }

    public AWTColor(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public AWTColor(int rgb) {
        super(rgb);
    }

    public AWTColor(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public AWTColor(float r, float g, float b) {
        super(r, g, b);
    }

    public AWTColor(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public AWTColor(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }
}
