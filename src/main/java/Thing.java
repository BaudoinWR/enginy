/**
 * Paquet de définition
 **/

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public abstract class Thing {
  Vector2D position = new Vector2D(0,0);

  public Thing() {
    System.things.add(this);
  }
  
  List<Consumer<Thing>> behaviors = new ArrayList<>();
  int getZIndex() { return 0; }
  void onCreate() {}
  void beforeUpdate() {}
  void update() {}
  void afterUpdate() {}
  void onDestroy() {}
  void draw(Graphics graphics) {}
  final void applyBehaviors() {
    behaviors.forEach(consumer -> consumer.accept(this));
  }
}
 
