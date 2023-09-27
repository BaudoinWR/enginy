package com.woobadeau.tinyengine.things.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.woobadeau.tinyengine.things.Thing;

public class Sprite extends Thing {

    protected Texture image;
    private boolean xFlipped;

    protected Sprite(String imageFile, int zIndex) {
        image = new Texture(Gdx.files.internal(imageFile));

        this.setZIndex(zIndex);
        //super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
    }

    protected Sprite(Texture imageFile, int zIndex) {
        image = imageFile;

        this.setZIndex(zIndex);
        //super(new Rectangle(0,0,image.getWidth(null), image.getHeight(null)));
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        if (xFlipped) {
            spriteBatch.draw(image, (int) getPosition().x + image.getWidth(), (int) getPosition().y, -image.getWidth(), image.getHeight());
        } else {
            spriteBatch.draw(image, (int) getPosition().x, (int) getPosition().y);
        }

    }

    public Sprite scale(int newW, int newH) {
     /*   image = ImageTools.resize((BufferedImage) getImage(), newW, newH);
        this.shape = (new Rectangle(shape.getBounds().x,shape.getBounds().y, getImage().getWidth(null), getImage().getHeight(null)));*/
        return this;
    }

    public Texture getImage() {
        return image;
    }

    public boolean isxFlipped() {
        return xFlipped;
    }

    public void setxFlipped(boolean xFlipped) {
        this.xFlipped = xFlipped;
    }
}
