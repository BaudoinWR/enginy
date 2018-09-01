package com.woobadeau.tinyengine; /**
 * Paquet de définition
 **/

/**
 * Description: Merci de donner une description du service rendu par cette interface
 **/
public class Movement extends Thing {
  public Vector2D speed = new Vector2D(0,0);
  Thing object;

  public Movement(Thing object) {
    this.object = object;
  }

  @Override
  int getZIndex() {
    return -1;
  }

  @Override
  public void update() {
    object.move(object.position.add(speed));
  }
}
 
