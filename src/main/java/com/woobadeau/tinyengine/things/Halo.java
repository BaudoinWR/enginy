package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.TinyEngine;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Halo extends Thing {

    private final int red;
    private final int green;
    private final int blue;
    private final int maxSize;
    private final int growthRate;
    private int currentSize;
    private boolean growing = true;

    public Halo(int red, int green, int blue, int size, int growthRate) {
        setZIndex(100);
        this.currentSize = growthRate == 0 ? size : 1;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.maxSize = size;
        this.growthRate = growthRate;
    }

    public Halo(int red, int green, int blue, int size) {
        this(red, green, blue, size, 0);
    }

    public Halo(Color color, int size, int growthRate) {
        this(color.getRed(), color.getGreen(), color.getBlue(), size, growthRate);
    }

    public Halo(Color color, int size) {
        this(color, size, 0);
    }

    @Override
    public void draw(Graphics graphics) {
        Color colors[] = { new Color(red, green, blue,150),
                new Color(red,green,blue,100),
                new Color(red,green,blue,25),
                new Color(red,green,blue,0),
        };
        float fractions[] = { 0.0f, 0.2f, 0.6f, 1.0f };

        RadialGradientPaint paint =
                new RadialGradientPaint(new Point((int) getPosition().x, (int) getPosition().y), currentSize, fractions, colors);
        ((Graphics2D)graphics).setPaint(paint);

        ((Graphics2D)graphics).fill(new Rectangle(TinyEngine.getSize()));
        super.draw(graphics);

        if (growing) {
            currentSize+=growthRate;
        } else {
            currentSize-=growthRate;
        }
        if (currentSize <= 1) {
            growing = true;
        }
        if (currentSize > maxSize) {
            growing = false;
        }

    }

}
