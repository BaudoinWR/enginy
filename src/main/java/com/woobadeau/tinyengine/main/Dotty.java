package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.physics.MovingDot;
import com.woobadeau.tinyengine.things.sprites.FollowSprite;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Dotty {
  private static final int DOTS = 10_000;
  public static void main(String[] args) throws IOException {
    new TinyEngine(600, 600);
    for (int i = 0; i < DOTS; i++) {
      new MovingDot(50,50,500,500);
    }

    new FollowSprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")));
  }

}