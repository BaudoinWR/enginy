/**
 * Paquet de définition
 **/

import java.util.function.Consumer;

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class ContainedBehavior implements Consumer<Thing>{

  private final int minY;
  private final int minX;
  private final int maxY;
  private final int maxX;

  public ContainedBehavior(int minX, int minY, int maxX, int maxY) {
    this.minY = minY;
    this.minX = minX;
    this.maxY = maxY;
    this.maxX = maxX;
  }

  public void accept(Thing thing) {
    if (thing.position.x > maxX) {
      thing.position.x = maxX;
    }
    if (thing.position.y > maxY) {
      thing.position.y = maxY;
    }
    if (thing.position.x < minX) {
      thing.position.x = minX;
    }
    if (thing.position.y < minY) {
      thing.position.y = minY;
    }
  }
}
 
