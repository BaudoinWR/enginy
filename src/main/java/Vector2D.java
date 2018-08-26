/**
 * Paquet de définition
 **/

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class Vector2D {
  int x, y;

  public Vector2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void add(Vector2D movement) {
    x += movement.x;
    y += movement.y;
  }
}
 
