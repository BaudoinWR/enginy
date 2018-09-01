package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.*;
import com.woobadeau.tinyengine.TinyEngine;
import org.omg.PortableInterceptor.IORInfo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dotty {
  private static final int DOTS = 10_000;
  private static Logger logger = Logger.getLogger(Dotty.class.getName());
  public static void main(String[] args) throws IOException {
    new TinyEngine();
    for (int i = 0; i < DOTS; i++) {
      new MovingDot(50,50,500,500);
    }

    new FollowSprite(ImageIO.read(Dotty.class.getResourceAsStream("/image.jpg")));
  }

}