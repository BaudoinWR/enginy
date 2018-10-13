package com.woobadeau.tinyengine.things.physics; /**
 * Paquet de définition
 **/

import com.woobadeau.tinyengine.things.Thing;

/**
 * Description: Merci de donner une description du service rendu par cette classe
 **/
public class Collider extends Thing {
  private final Thing object;

  public Collider(Thing object) {
    this.object = object;
  }

}

