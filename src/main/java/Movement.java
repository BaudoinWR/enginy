/**
 * Paquet de définition
 **/

/**
 * Description: Merci de donner une description du service rendu par cette interface
 **/
public class Movement extends Thing  {
  Vector2D speed = new Vector2D(0,0);
  Thing object;

  public Movement(Thing object) {
    super();
    this.object = object;
  }

  @Override
  public void update() {
    object.position.add(speed);
  }
}
 
