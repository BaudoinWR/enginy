package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ui.Color;
import com.woobadeau.tinyengine.things.ui.Display;

public class Halo extends Thing {

    private final int red;
    private final int green;
    private final int blue;
    private final int maxSize;
    private final int growthRate;
    private int currentSize;
    private boolean growing = true;

    public Halo(Integer red, Integer green, Integer blue, Integer size, Integer growthRate) {
        setZIndex(100);
        this.currentSize = growthRate == 0 ? size : 1;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.maxSize = size;
        this.growthRate = growthRate;
        this.setShape(TinyEngine.uiInterfaceProvider.getCircle(getPosition().x   , getPosition().y, 100, 100));
    }

    public Halo(Integer red, Integer green, Integer blue, Integer size) {
        this(red, green, blue, size, 0);
    }

    public Halo(Color color, Integer size, Integer growthRate) {
        this(color.getRed(), color.getGreen(), color.getBlue(), size, growthRate);
    }

    public Halo(Color color, Integer size) {
        this(color, size, 0);
    }

    @Override
    public void draw(Display display) {
        display.drawHalo(red, green, blue, getPosition().x, getPosition().y, currentSize);

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
