package com.woobadeau.tinyengine.main;

import com.woobadeau.tinyengine.ScrollingBackground;
import com.woobadeau.tinyengine.TinyEngine;

import java.io.IOException;

public class Scroll {
    public static void main(String[] args) throws IOException {
        new TinyEngine(2048, 1536);
        new ScrollingBackground("/Hills__0000.png", 6);
        new ScrollingBackground("/Hills__0001.png", 4);
        new ScrollingBackground("/Hills__0002.png", 2);
        new ScrollingBackground("/Hills__0003.png", 1);
        new ScrollingBackground("/Hills__0004_Sky.png", 0);
    }
}
