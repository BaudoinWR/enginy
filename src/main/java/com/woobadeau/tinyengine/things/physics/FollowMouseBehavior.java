package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Thing;

import java.util.function.Consumer;

public class FollowMouseBehavior implements Consumer<Thing> {
    @Override
    public void accept(Thing thing) {
        if (TinyEngine.mousePosition != null) {
            thing.move(new Vector2D(TinyEngine.mousePosition.x, TinyEngine.mousePosition.y));
        }
    }
}
