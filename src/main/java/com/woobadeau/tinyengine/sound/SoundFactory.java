package com.woobadeau.tinyengine.sound;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundFactory {
    public static Clip getClip(String resourceName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        var audioInputStream =
                AudioSystem.getAudioInputStream(SoundFactory.class.getResourceAsStream(resourceName));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        return clip;
    }
}
