package com.woobadeau.tinyengine.sound;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundFactory {
    static Audio audio = Gdx.audio;
    public static Sound getSound(String resourceName) {
        return audio.newSound(Gdx.files.internal(resourceName));
    }

    public static Music getMusic(String resourceName) {
        return audio.newMusic(Gdx.files.internal(resourceName));
    }

    public static void setVolume(Sound sound, long id, float volume) {
        sound.setVolume(id, volume);
    }
}
