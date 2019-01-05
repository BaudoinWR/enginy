package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.main.Dotty;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ThingMouseClickListener;
import com.woobadeau.tinyengine.things.physics.Collider;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.Timer;

public class TinyEngine {
  private static Logger logger = Logger.getLogger(Dotty.class.getName());
  private static final Set<Thing> things = new HashSet<>();
  private static final Set<Thing> allThingsCollidable = new HashSet<>();
  private static final Set<Thing> thingsToBeRemoved = new HashSet<>();

  public static Display display = new Display();
  public static BufferedImage screen = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
  public static Point mousePosition;
  public static int width;
  private static int height;
  public static boolean mouseDown = false;

  public static boolean debug = false;
  private static boolean restart = false;
  private static Timer timer;
  private Runnable initialization;

  public TinyEngine(int width, int height, Runnable initialization) {
    this.initialization = initialization;
    EventQueue.invokeLater(() -> {
      TinyEngine.width = width;
      TinyEngine.height = height;
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
  }

  public void restart() {
    timer.stop();
    restart = true;
  }

  public void start() {
    initialization.run();
    timer = new Timer(1000/25, e -> tick());
    timer.setRepeats(true);
    timer.setCoalesce(true);
    timer.start();
  }

  private static void clearAll() {
    things.clear();
    allThingsCollidable.clear();
    thingsToBeRemoved.clear();
  }

  void tick() {
    List<Thing> allThings = things.stream().sorted(Comparator.comparing(Thing::getZIndex)).collect(Collectors.toList());
    mousePosition = display.getMousePosition();
    applyActions(allThings);
    draw(allThings);
    display.repaint();
    if (restart) {
      restart = false;
      clearAll();
      start();
    }
  }

  private static void applyActions(List<Thing> allThings) {
    allThings.forEach(Thing::beforeUpdate);
    allThings.forEach(Thing::update);
    allThings.forEach(Thing::afterUpdate);
    allThings.forEach(Thing::applyBehaviors);
    allThingsCollidable.stream().filter(t -> t instanceof Collider).forEach(TinyEngine::testCollision);
    things.removeAll(thingsToBeRemoved);
    allThingsCollidable.removeAll(thingsToBeRemoved);
    thingsToBeRemoved.clear();
  }

  private static void testCollision(Thing t) {
    allThingsCollidable.stream().filter(thing -> thing != t && t.getShape().getBounds().intersects(thing.getShape().getBounds()))
    .forEach(((Collider) t)::collides);
  }

  private static void draw(List<Thing> allThings) {
    screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = screen.createGraphics();
    allThings.forEach(thing -> { if (thing.isVisible()) thing.draw(graphics); });
  }

  public static void register(Thing thing) {
    things.add(thing);
    if (thing instanceof Collider) {
      allThingsCollidable.add(thing);
    }
  }

  public static void remove(Thing thing) {
    thingsToBeRemoved.add(thing);
  }

  public static Dimension getSize() {
    return display.getSize();
  }

  public static boolean isDebug() {
    return debug;
  }

  public static void addKeyBinding(String key, Runnable action) {
    display.getInputMap().put(KeyStroke.getKeyStroke(key), key);
    display.getActionMap().put(key, new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        action.run();
      }
    });
  }

  private static class Display extends JPanel implements MouseListener {

    public Display() {
      this.addMouseListener(this);
      setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      int x = (getWidth() - screen.getWidth()) / 2;
      int y = (getHeight() - screen.getHeight()) / 2;
      g2d.drawImage(screen, x, y, this);
      g2d.dispose();
    }

    private <T> void propagate(final Class<T> listenerClass, Consumer<T> action) {
      things.stream()
              .filter(t -> listenerClass.isAssignableFrom(t.getClass()))
              .filter(t -> t.getShape() != null && t.getShape().contains(mousePosition.x, mousePosition.y))
              .map(listenerClass::cast)
              .forEach(action);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      //propagate(ThingMouseClickListener::onClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {
      mouseDown = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      mouseDown = false;
      propagate(ThingMouseClickListener.class, ThingMouseClickListener::onClick);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

  }

}
 
