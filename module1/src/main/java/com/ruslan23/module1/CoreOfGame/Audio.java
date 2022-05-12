package com.ruslan23.module1.CoreOfGame;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
public class Audio {
    private SoundPool soundPool1;
    private AssetManager assetManager1;
    public Sound1 newSound(String name) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = assetManager1.openFd(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int my_sound = soundPool1.load(assetFileDescriptor, 0);
        return new Sound1(my_sound, soundPool1);
    }
    public Music1 newMusic(String name) {
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager1.openFd(name);
            return new Music1(assetFileDescriptor);
        } catch (IOException e) { throw new RuntimeException("music is not found"); }
    }
    public Audio(Activity i) {
        i.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        assetManager1 = i.getAssets();
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
        soundPool1 = new SoundPool.Builder().setAudioAttributes(audioAttributes).build();
    }
}