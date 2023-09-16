package com.woobadeau.tinyengine.things.ui;

import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.physics.Vector2D;

import java.awt.*;

public class Text extends Thing {

    protected String string;
    private Font font;
    private Color color;

    public Text(String string, Font font, Color color, Vector2D position) {
        this.string = string;
        this.font = font;
        this.color = color;
        this.move(position);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setFont(font);
        graphics.setColor(color);
        graphics.drawString(string, (int) getPosition().x, (int) getPosition().y);
    }
}
