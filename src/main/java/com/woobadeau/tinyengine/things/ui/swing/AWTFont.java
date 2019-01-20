package com.woobadeau.tinyengine.things.ui.swing;

import java.awt.Font;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class AWTFont extends Font implements com.woobadeau.tinyengine.things.ui.Font {

    public AWTFont(String name, int style, int size) {
        super(name, style, size);
    }

    public AWTFont(Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        super(attributes);
    }

    protected AWTFont(Font font) {
        super(font);
    }
}
