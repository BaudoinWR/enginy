package com.woobadeau.tinyengine.behavior;

import com.woobadeau.tinyengine.things.Thing;

public class BlinkBehavior implements Behavior {

    private long lastBlink;
    private final int intervalMs;

    public BlinkBehavior(int intervalMs) {
        this.intervalMs = intervalMs;
        this.lastBlink = System.currentTimeMillis();
    }


    @Override
    public void accept(Thing thing) {
        if (System.currentTimeMillis() > lastBlink + intervalMs) {
            thing.setVisible(!thing.isVisible());
            lastBlink = System.currentTimeMillis();
        }
    }
}
