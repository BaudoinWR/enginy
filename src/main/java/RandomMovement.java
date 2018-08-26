/**
 * Paquet de définition
 **/

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class RandomMovement extends Movement {


  private double max = 10;
  private double min = -10;

  public RandomMovement(Thing object) {
    super(object);
  }

  @Override
  public void beforeUpdate() {
    speed.x = (int) getRandom();
    speed.y = (int) getRandom();
    super.update();
  }

  private double getRandom() {
    return (Math.random() * ((max - min) + 1)) + min;
  }
}
 
