package com.woobadeau.firelight.main;

import com.woobadeau.firelight.ColorManager;
import com.woobadeau.firelight.WolfAnimation;
import com.woobadeau.tinyengine.*;
import com.woobadeau.tinyengine.main.SampleBackground;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Firelight {

    public static void main(String[] args) throws IOException {
        new SampleBackground();
        ColorManager.getInstance();
        new TinyEngine(1024, 740);
        new WolfAnimation();
    }
}
