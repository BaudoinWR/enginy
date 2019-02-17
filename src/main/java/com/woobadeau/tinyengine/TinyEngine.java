package com.woobadeau.tinyengine;

import com.woobadeau.tinyengine.main.Dotty;
import com.woobadeau.tinyengine.things.Thing;
import com.woobadeau.tinyengine.things.physics.Collider;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.UIInterfaceProvider;

import javax.swing.Timer;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TinyEngine {
  private static final Logger LOGGER = Logger.getLogger(Dotty.class.getName());
  private static final Set<Thing> things = new HashSet<>();
  private static final Set<Thing> collidables = new HashSet<>();
  private static final Set<Thing> thingsToBeRemoved = new HashSet<>();
  private static final Set<Thing> thingsToBeAdded = new HashSet<>();
  private static final Set<Thing> collidablesToBeAdded = new HashSet<>();

  public static Display display;
  public static Vector2D mousePosition;
  public static int width;
  private static int height;
  public static boolean mouseDown = false;

  public static boolean debug = false;
  private static boolean restart = false;
  private static Timer timer;
  private static Runnable initialization;
  public static UIInterfaceProvider uiInterfaceProvider;

  public static void setup(int width, int height, Runnable initialization, UIInterfaceProvider uiInterfaceProvider) {
    TinyEngine.width = width;
    TinyEngine.height = height;
    TinyEngine.uiInterfaceProvider = uiInterfaceProvider;
    TinyEngine.display = uiInterfaceProvider.initDisplay(width, height);
    TinyEngine.initialization = initialization;
  }

  public static void setup(Runnable initialization) {
    TinyEngine.initialization = initialization;
  }

  public static void restart() {
    if (timer != null && timer.isRunning()) {
      restart = true;
    } else {
      start();
    }
  }

  public static void start() {
    clearAll();
    initialization.run();
    timer = new Timer(1000/25, e -> tick());
    timer.setRepeats(true);
    timer.setCoalesce(true);
    timer.start();
  }

  private static void clearAll() {
    things.forEach(Thing::destroy);
    things.clear();
    collidables.clear();
    thingsToBeRemoved.clear();
    thingsToBeAdded.clear();
  }

  static void tick() {
    List<Thing> allThings = things.stream().sorted(Comparator.comparing(Thing::getZIndex)).collect(Collectors.toList());
    mousePosition = display.getMousePositionVector();
    applyActions(allThings);
    draw(allThings);
    display.repaint();
    manageNewAndOldThings();
    if (restart) {
      timer.stop();
      restart = false;
      start();
    }
  }

  private static void applyActions(List<Thing> allThings) {
    allThings.forEach(Thing::beforeUpdate);
    allThings.forEach(Thing::update);
    allThings.forEach(Thing::afterUpdate);
    allThings.forEach(Thing::applyBehaviors);
    collidables.stream().filter(t -> t instanceof Collider).forEach(TinyEngine::testCollision);
  }

  private static void manageNewAndOldThings() {
    things.removeAll(thingsToBeRemoved);
    things.addAll(thingsToBeAdded);
    collidables.removeAll(thingsToBeRemoved);
    collidables.addAll(collidablesToBeAdded);
    thingsToBeRemoved.clear();
    thingsToBeAdded.clear();
    collidablesToBeAdded.clear();
  }

  private static void testCollision(Thing t) {
    collidables.stream().filter(thing -> thing != t && t.getShape().intersects(thing.getShape()))
    .forEach(((Collider) t)::collides);
  }

  private static void draw(List<Thing> allThings) {
    allThings.forEach(thing -> { if (thing.isVisible()) thing.draw(display); });
  }

  private static void register(Thing thing) {
    thingsToBeAdded.add(thing);
    if (thing instanceof Collider) {
      collidablesToBeAdded.add(thing);
    }
  }

  public static void remove(Thing thing) {
    thingsToBeRemoved.add(thing);
  }

  public static boolean isDebug() {
    return debug;
  }

  public static void addKeyBinding(String key, Runnable action) {
    display.addKeyBinding(key, action);
  }

  public static <T> void propagate(final Class<T> listenerClass, Consumer<T> action) {
    things.stream()
            .filter(t -> listenerClass.isAssignableFrom(t.getClass()))
            .filter(t -> t.getShape() != null && t.getShape().contains(mousePosition.x, mousePosition.y))
            .map(listenerClass::cast)
            .forEach(action);
  }

  /**
   * Creates a thing with arguments then calls the callback on it for initialization purposes.
   * @param <T> type of spawned object
   * @param toSpawn class of thing to spawn
   * @param callback method
   * @throws NoSuchMethodException if no constructor found with the arguments
   */
  public static <T extends Thing> CompletableFuture<T> spawn(Supplier<T> toSpawn, Consumer<T> callback) {
    return CompletableFuture.supplyAsync(() -> {
      T thing = toSpawn.get();
      if (callback != null) {
        callback.accept(thing);
      }
      register(thing);
      return thing;
    });
  }

  /**
   * Creates a thing with arguments then calls the callback on it for initialization purposes.
   * @param <T> type of spawned object
   * @param toSpawn class of thing to spawn
   * @throws NoSuchMethodException if no constructor found with the arguments
   */
  public static <T extends Thing> CompletableFuture<T> spawn(Supplier<T> toSpawn) {
    return spawn(toSpawn, null);
  }

}
 
