package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.things.physics.FollowBehavior;
import com.woobadeau.tinyengine.things.physics.FollowMouseBehavior;
import com.woobadeau.tinyengine.things.physics.MovingDot;
import com.woobadeau.tinyengine.things.ui.swing.SwingUIInterfaceProvider;

public class Dotty {
  public static void main(String[] args) {
    new TinyEngine(600, 600, () -> {
    }, new SwingUIInterfaceProvider()).start();

    TinyEngine.spawn(() -> new MovingDot(50, 50, 500, 500), Dotty::followingHalo);
    TinyEngine.spawn(() -> new Halo(0,0,255,50, 10),
        halo -> halo.getBehaviors().add(new FollowMouseBehavior()::follow));
  }

  private static void followingHalo(MovingDot dot) {
    TinyEngine.spawn(() -> new Halo(255, 155, 0, 100),
        halo -> halo.getBehaviors().add(new FollowBehavior(dot)::follow));
  }
}