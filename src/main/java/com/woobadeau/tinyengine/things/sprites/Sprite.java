package com.woobadeau.tinyengine.things.sprites;

import com.woobadeau.tinyengine.things.RectangularThing;
import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.Image;

public class Sprite extends RectangularThing {

    protected Image image;

    public Sprite(Image image, Integer zIndex) {
        super(TinyEngine.uiInterfaceProvider.getRectangle(0,0,image.getWidth(), image.getHeight()));
        this.image = image;
        this.setZIndex(zIndex);
    }

    @Override
    public void draw(Display display) {
        display.drawImage(image, getPosition().x, getPosition().y, TinyEngine.display);
        if (TinyEngine.isDebug()) {
            display.setColor(TinyEngine.uiInterfaceProvider.getColorGreen());
            display.draw(getShape());
        }

    }

    public Sprite scale(Integer newW, Integer newH) {
        image = TinyEngine.uiInterfaceProvider.resize(image, newW, newH);
        this.setShape(TinyEngine.uiInterfaceProvider.getRectangle((int)this.getShape().getX(),(int) this.getShape().getY(), image.getWidth(), image.getHeight()));
        return this;
    }

    public Image getImage() {
        return image;
    }
}
