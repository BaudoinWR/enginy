package com.woobadeau.tinyengine.behavior;

import com.woobadeau.tinyengine.things.Thing;

import com.woobadeau.tinyengine.things.physics.Collider;
import com.woobadeau.tinyengine.things.physics.Vector2D;

public class FollowBehavior implements Behavior {

    private Thing toFollow;

    public FollowBehavior(Thing toFollow) {
        this.toFollow = toFollow;
    }

    @Override
    public void accept(Thing thing) {
        if (toFollow instanceof Collider) {
            thing.moveTo(new Vector2D((int) ((Collider)toFollow).getCollidingZone().getCenterX(), (int) ((Collider)toFollow).getCollidingZone().getCenterY()));
        }
        else {
            thing.moveTo(toFollow.getPosition());
        }
    }
}
