package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.BlinkBehavior;
import com.woobadeau.tinyengine.things.Halo;
import com.woobadeau.tinyengine.things.physics.FollowBehavior;
import com.woobadeau.tinyengine.things.physics.FollowMouseBehavior;
import com.woobadeau.tinyengine.things.physics.MovingDot;
import com.woobadeau.tinyengine.things.sprites.FollowSprite;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Dotty {
  private static final int DOTS = 10_000;
  public static void main(String[] args) throws IOException {
    new TinyEngine(600, 600);
    /*
    for (int i = 0; i < DOTS; i++) {
      new MovingDot(50,50,500,500);
    }
    */
    Halo halo = new Halo(255, 155, 0, 100);
    MovingDot movingDot = new MovingDot(50, 50, 500, 500);
    halo.getBehaviors().add(new FollowBehavior(movingDot));
    new Halo(0,0,255,50, 10).getBehaviors().add(new FollowMouseBehavior());
    // halo.getBehaviors().add(new BlinkBehavior(100));

    //new FollowSprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")));
  }

}