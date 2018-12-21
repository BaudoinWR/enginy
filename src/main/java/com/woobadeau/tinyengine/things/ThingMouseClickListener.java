package com.woobadeau.tinyengine.things;

public interface ThingMouseClickListener extends ThingMouseListener {
    default void onClick() {}
}
