package com.woobadeau.tinyengine.things;

public class BlinkBehavior {

    private long lastBlink;
    private final int intervalMs;

    public BlinkBehavior(Integer intervalMs) {
        this.intervalMs = intervalMs;
        this.lastBlink = System.currentTimeMillis();
    }

    public void blink(Thing thing) {
        if (System.currentTimeMillis() > lastBlink + intervalMs) {
            thing.setVisible(!thing.isVisible());
            lastBlink = System.currentTimeMillis();
        }
    }
}
