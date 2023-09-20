package com.woobadeau.tinyengine.things;


public abstract class Spawner extends Thing {

    @Override
    public void update() {
        super.update();
        int howMany = shouldSpawn();
        for (int i = 0; i < howMany; i++) {
            getThings().add(spawn());
        }
    }

    protected abstract Thing spawn();

    protected abstract int shouldSpawn();
}
