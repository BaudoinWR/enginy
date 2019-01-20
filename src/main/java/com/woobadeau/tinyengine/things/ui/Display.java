package com.woobadeau.tinyengine.things.ui;

import com.woobadeau.tinyengine.things.physics.Vector2D;

import java.awt.Image;

public interface Display {
    void drawImage(Image image, int x, int y, Display display);

    void setColor(Color color);

    void draw(Shape shape);

    Color getGreen();

    void setFont(Font font);

    void drawString(String string, int x, int y);

    void drawHalo(int red, int green, int blue, int x, int y, int currentSize);

    Color getRed();

    void drawOval(int x, int y, int i, int i1);

    void addKeyBinding(String key, Runnable action);

    void repaint();

    Vector2D getMousePositionVector();
}
