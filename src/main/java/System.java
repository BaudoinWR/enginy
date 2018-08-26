/**
 * Paquet de définition
 **/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class System {
  private static Logger logger = Logger.getLogger(Dotty.class.getName());
  static List<Thing> things = new ArrayList<>();
  static Display display = new Display();
  private static BufferedImage bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);

  public System() {
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
    collect.forEach(Thing::beforeUpdate);
    collect.forEach(Thing::update);
    collect.forEach(Thing::afterUpdate);
    collect.forEach(Thing::applyBehaviors);
    bufferedImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    collect.forEach(thing -> thing.draw(graphics));
    display.repaint();
  }

  public static Dimension getSize() {
    return display.getSize();
  }

  private static class Display extends JPanel {
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
  }
}
 
