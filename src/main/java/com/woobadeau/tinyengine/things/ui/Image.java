package com.woobadeau.tinyengine.things.ui;

public interface Image {
    int getWidth();

    int getHeight();

    Image getSubImage(int i, int i1, int width, int height);

    int getRGB(int x, int y);

    void setRGB(int x, int y, int rgb);
}
