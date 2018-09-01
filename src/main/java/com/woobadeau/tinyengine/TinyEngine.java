package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.main.Dotty;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.Timer;

public class TinyEngine {
  private static Logger logger = Logger.getLogger(Dotty.class.getName());
  private static Set<Thing> things = new HashSet<>();
  static Display display = new Display();
  private static BufferedImage bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
  public static Point mousePosition;

  public TinyEngine() {
    EventQueue.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        logger.log(Level.SEVERE, "Error", ex);
      }

      JFrame frame = new JFrame("Testing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.add(display);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
    Timer timer;
    timer = new Timer(1000/25, e -> {tick();});
    timer.setRepeats(true);
    timer.setCoalesce(true);
    timer.start();
  }

  static void tick() {
    List<Thing> collect = things.stream().sorted(Comparator.comparing(Thing::getZIndex)).collect(Collectors.toList());
    mousePosition = display.getMousePosition();
    applyActions(collect);
    draw(collect);
    display.repaint();
  }

  private static void draw(List<Thing> collect) {
    bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    collect.forEach(thing -> thing.draw(graphics));
  }

  private static void applyActions(List<Thing> collect) {
    collect.forEach(Thing::beforeUpdate);
    collect.forEach(Thing::update);
    collect.forEach(Thing::afterUpdate);
    collect.forEach(Thing::applyBehaviors);
  }

  public static void register(Thing thing) {
    things.add(thing);
  }

  public static void remove(Thing thing) {
    thing.onDestroy();
    things.remove(thing);
  }

  public static Dimension getSize() {
    return display.getSize();
  }

  private static class Display extends JPanel implements MouseListener {

    public Display() {
      this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(600, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      int x = (getWidth() - bufferedImage.getWidth()) / 2;
      int y = (getHeight() - bufferedImage.getHeight()) / 2;
      g2d.drawImage(bufferedImage, x, y, this);
      g2d.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      things.stream()
              .filter(t -> t.shape != null && t.shape.contains(mousePosition.x, mousePosition.y))
              .filter(t -> t instanceof ThingMouseListener)
              .map(ThingMouseListener.class::cast)
              .forEach(ThingMouseListener::onClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
  }

}
 
