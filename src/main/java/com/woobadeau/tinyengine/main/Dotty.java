package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.things.ProgressBar;
import com.woobadeau.tinyengine.things.physics.FollowBehavior;
import com.woobadeau.tinyengine.things.physics.FollowMouseBehavior;
import com.woobadeau.tinyengine.things.physics.MovingDot;
import com.woobadeau.tinyengine.things.ui.swing.SwingUIInterfaceProvider;

import static com.woobadeau.tinyengine.TinyEngine.uiInterfaceProvider;

public class Dotty {
  private static double percent = 0;
  public static void main(String[] args) {
    TinyEngine.setup(600, 600, () -> {
    }, new SwingUIInterfaceProvider());
    TinyEngine.start();

    TinyEngine.spawn(() -> new MovingDot(50, 50, 500, 500), Dotty::followingHalo);
    TinyEngine.spawn(() -> new Halo(0,0,255,50, 10),
        halo -> halo.getBehaviors().add(new FollowMouseBehavior()::follow));
    TinyEngine.spawn(() -> new ProgressBar(uiInterfaceProvider.getRectangle(50, 50, 100, 20),
            uiInterfaceProvider.getGreen(), uiInterfaceProvider.getRed(), Dotty::getPercent));
  }

  private static Double getPercent() {
    percent += 0.01;
    if (percent > 1) {
      percent = 0;
    }
    return percent;
  }

  private static void followingHalo(MovingDot dot) {
    TinyEngine.spawn(() -> new Halo(255, 155, 0, 100),
        halo -> halo.getBehaviors().add(new FollowBehavior(dot)::follow));
  }
}