package com.woobadeau.tinyengine.sound;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundFactory {
    public static Clip getClip(String resourceName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream resourceAsStream = SoundFactory.class.getResourceAsStream(resourceName);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(resourceAsStream));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        return clip;
    }
}
