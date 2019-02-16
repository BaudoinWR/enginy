package com.woobadeau.tinyengine.things.ui;

import com.woobadeau.tinyengine.things.physics.Vector2D;

public interface Display {
    void drawImage(Image image, int x, int y, Display display);

    void setColor(Color color);

    void draw(Shape shape);

    void fillRectangle(Shape shape);

    void setFont(Font font);

    void drawString(String string, int x, int y);

    void drawHalo(int red, int green, int blue, int x, int y, int currentSize);

    void drawOval(int x, int y, int i, int i1);

    void addKeyBinding(String key, Runnable action);

    void repaint();

    Vector2D getMousePositionVector();

    void fillOval(int x, int y, int width, int height);

}
