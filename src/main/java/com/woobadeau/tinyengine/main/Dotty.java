package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.things.physics.FollowBehavior;
import com.woobadeau.tinyengine.things.physics.FollowMouseBehavior;
import com.woobadeau.tinyengine.things.physics.MovingDot;

public class Dotty {
  public static void main(String[] args) {
    new TinyEngine(600, 600);
    Halo halo = new Halo(255, 155, 0, 100);
    MovingDot movingDot = new MovingDot(50, 50, 500, 500);
    halo.getBehaviors().add(new FollowBehavior(movingDot));
    new Halo(0,0,255,50, 10).getBehaviors().add(new FollowMouseBehavior());
  }

}