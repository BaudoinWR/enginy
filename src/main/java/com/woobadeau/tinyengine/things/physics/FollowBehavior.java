package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.things.Thing;

import java.util.function.Consumer;

public class FollowBehavior implements Consumer<Thing> {

    private Thing toFollow;

    public FollowBehavior(Thing toFollow) {
        this.toFollow = toFollow;
    }

    @Override
    public void accept(Thing thing) {
        if (toFollow.getShape() != null) {
            thing.move(new Vector2D((int) toFollow.getShape().getBounds().getCenterX(), (int) toFollow.getShape().getBounds().getCenterY()));
        }
        else {
            thing.move(toFollow.getPosition());
        }
    }
}
