package com.woobadeau.tinyengine;

public class RandomMovement extends Movement {


  private double max = 10;
  private double min = -10;

  public RandomMovement(Thing object) {
    super(object);
  }

  @Override
  public void beforeUpdate() {
    speed = new Vector2D((int)getRandom(), (int)getRandom());
    super.update();
  }

  private double getRandom() {
    return (Math.random() * ((max - min) + 1)) + min;
  }
}
 
