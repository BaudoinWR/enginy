package com.woobadeau.tinyengine.things;

import java.util.function.Consumer;

public class BlinkBehavior implements Consumer<Thing> {

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
