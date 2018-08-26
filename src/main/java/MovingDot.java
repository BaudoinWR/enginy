/**
 * Paquet de définition
 **/

import java.awt.*;
import java.util.Random;

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class MovingDot extends Thing {
  Random rand = new Random();
  Movement movement;

  public MovingDot(int minX, int minY, int maxX, int maxY) {
    movement = new RandomMovement(this);
    this.position.x = rand.nextInt(50);
    this.position.y = rand.nextInt(50);
    this.behaviors.add(new ContainedBehavior(minX, minY, maxX, maxY));
  }

  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(Color.BLUE);
    graphics.drawOval(this.position.x, this.position.y, 5, 5);
  }
}
 
