/*
 * ADOBE CONFIDENTIAL
 * ___________________
 *
 * Copyright 2023 Adobe
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains
 * the property of Adobe and its suppliers, if any. The intellectual
 * and technical concepts contained herein are proprietary to Adobe
 * and its suppliers and are protected by all applicable intellectual
 * property laws, including trade secret and copyright laws.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe.
 */
package com.woobadeau.tinyengine.behavior;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.Thing;

public class DestroyOutOfScreenBehavior implements Behavior {
  @Override
  public void accept(Thing thing) {
    if (thing.getPosition().x > TinyEngine.width || thing.getPosition().x < 0 || thing.getPosition().y > TinyEngine.width || thing.getPosition().y < 0) {
      thing.destroy();
    }
  }
}
