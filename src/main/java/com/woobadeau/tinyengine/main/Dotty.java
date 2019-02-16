package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.things.physics.FollowBehavior;
import com.woobadeau.tinyengine.things.physics.FollowMouseBehavior;
import com.woobadeau.tinyengine.things.physics.MovingDot;
import com.woobadeau.tinyengine.things.ui.swing.SwingUIInterfaceProvider;

public class Dotty {
  public static void main(String[] args) throws NoSuchMethodException {
    new TinyEngine(600, 600, () -> {
    }, new SwingUIInterfaceProvider()).start();

    TinyEngine.spawn(MovingDot.class, Dotty::followingHalo, 50, 50, 500, 500);
    TinyEngine.spawn(Halo.class, halo -> halo.getBehaviors().add(new FollowMouseBehavior()),0,0,255,50, 10);
  }

  private static void followingHalo(MovingDot dot) {
    try {
      TinyEngine.spawn(Halo.class,
              halo -> halo.getBehaviors().add(new FollowBehavior(dot)), 255, 155, 0, 100);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}