package com.woobadeau.tinyengine.things.physics;

import com.woobadeau.tinyengine.things.Thing;

import java.util.function.Consumer;

public class FollowBehavior {

    private Thing toFollow;

    public FollowBehavior(Thing toFollow) {
        this.toFollow = toFollow;
    }

    public void follow(Thing thing) {
        if (toFollow.getShape() != null) {
            thing.move(new Vector2D((int) toFollow.getShape().getCenterX(), (int) toFollow.getShape().getCenterY()));
        }
        else {
            thing.move(toFollow.getPosition());
        }
    }
}
