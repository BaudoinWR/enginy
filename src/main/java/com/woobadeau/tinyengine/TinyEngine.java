package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.ThingMouseClickListener;
import com.woobadeau.tinyengine.things.physics.Collider;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;

public class TinyEngine {
    private static int scale = 1;
    private static final Logger LOG = Logger.getLogger(TinyEngine.class.getName());
  private static final Set<Thing> things = new HashSet<>();
  private static final Set<Thing> thingsToBeRemoved = new HashSet<>();

  public static Display display = new Display();
  public static BufferedImage screen;
  public static Point mousePosition;
  public static int width;
  public static int height;
  public static boolean mouseDown = false;

  public static boolean debug = false;
  private static boolean restart = false;
  private static Timer timer;
  private Runnable initialization;
  private static long ticks;
    public TinyEngine(int width, int height, Runnable initialization) {
        this(width, height, 1, initialization);
    }
    public TinyEngine(int width, int height, int scale, Runnable initialization) {
    TinyEngine.scale = scale;
    this.initialization = initialization;
    EventQueue.invokeLater(() -> {
      TinyEngine.width = width;
      TinyEngine.height = height;
        screen = new BufferedImage(TinyEngine.width, TinyEngine.height, BufferedImage.TYPE_INT_ARGB);

        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        LOG.log(Level.SEVERE, "Error", ex);
      }

      JFrame frame = new JFrame("Testing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.add(display);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.setResizable(false);
    });
  }

  public void restart() {
    timer.stop();
    restart = true;
  }

  public void start() {
        LOG.info("Starting TinyEngine");
    ticks = 0;
    initialization.run();
    timer = new Timer(1000/25, e -> tick());
    timer.setRepeats(true);
    timer.setCoalesce(true);
    timer.start();
  }

  private static void clearAll() {
    things.clear();
    thingsToBeRemoved.clear();
  }

  void tick() {
    ticks++;
    List<Thing> allThings = things.stream()
            .sorted(Comparator.comparing(Thing::getZIndex))
            .distinct()
            .toList();
      setMousePosition();
      applyActions(allThings);
    draw(allThings);
    display.repaint();
    if (restart) {
      restart = false;
      clearAll();
      start();
    }
  }

    private static void setMousePosition() {
        Point actualMousePosition = display.getMousePosition();
        if (actualMousePosition == null) {
            return;
        }
        mousePosition = new Point(actualMousePosition.x / scale, actualMousePosition.y / scale);
    }

    private static void applyActions(List<Thing> allThings) {
    allThings.forEach(Thing::beforeUpdate);
    allThings.forEach(Thing::update);
    allThings.forEach(Thing::afterUpdate);
    allThings.forEach(Thing::applyBehaviors);
    collide(things.stream()
            .filter(t -> t instanceof Collider)
            .toList());
    things.removeAll(thingsToBeRemoved);
    thingsToBeRemoved.forEach(Thing::onRemove);
  }

  private static void collide(List<Thing> things) {
      for (int i = 0; i < things.size(); i++) {
          Thing thing = things.get(i);
          for (int j = i + 1; j < things.size(); j++) {
              Thing otherThing = things.get(j);
              if (thing.getShape().getBounds().intersects(otherThing.getShape().getBounds())) {
                  ((Collider) thing).collides(otherThing);
                  ((Collider) otherThing).collides(thing);
              }
          }
      }
  }

  private static void draw(List<Thing> allThings) {
    screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = screen.createGraphics();
    allThings.forEach(thing -> { if (thing.isVisible()) thing.draw(graphics); });
  }

  public static void register(Thing thing) {
    things.add(thing);
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

    public static long getTicks() {
        return ticks;
    }

    private static class Display extends JPanel implements MouseListener {

    public Display() {
      this.addMouseListener(this);
      setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(width * scale, height * scale);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      Image scaledScreen = screen.getScaledInstance(screen.getWidth() * scale, screen.getHeight() * scale, Image.SCALE_DEFAULT);
      int x = (getWidth() - scaledScreen.getWidth(null)) / 2;
      int y = (getHeight() - scaledScreen.getHeight(null)) / 2;
      g2d.drawImage(scaledScreen, x, y, this);
      g2d.dispose();
    }

    private <T> void propagate(final Class<T> listenerClass, Consumer<T> action) {
      things.stream()
              .filter(t -> listenerClass.isAssignableFrom(t.getClass()))
              .filter(t -> {
                  return t.getShape() != null && t.getShape().getBounds().contains(mousePosition.x, mousePosition.y);
              })
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
      System.out.printf("%s:%s%n",e.getX(), e.getY());
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

