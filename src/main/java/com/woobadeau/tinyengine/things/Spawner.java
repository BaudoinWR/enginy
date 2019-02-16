package com.woobadeau.tinyengine.things;

import com.woobadeau.tinyengine.TinyEngine;

import java.util.function.Supplier;

public class Spawner<T extends Thing> extends Thing {

    private final Supplier<T> supplier;
    private final Supplier<Boolean> test;

    public Spawner(Supplier<T> supplier, Supplier<Boolean> test) {
        this.supplier = supplier;
        this.test = test;
    }

    @Override
    public void update() {
        super.update();
        if (test.get()) {
            TinyEngine.spawn(supplier, thing -> thing.move(this.getPosition()));
        }
    }


}
