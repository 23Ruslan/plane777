package com.ruslan23.module1.CoreOfGame;
import android.media.MediaPlayer;
import android.content.res.AssetFileDescriptor;

import java.io.IOException;

public class Music1 {

    private boolean prepared;
    private MediaPlayer mediaPlayer1;

    public void play(boolean loop, float vol) {
        if (mediaPlayer1.isPlaying()) {return;}
        synchronized (this) {
            if (prepared == false) {
                try {mediaPlayer1.prepare();} catch (IOException e) {e.printStackTrace();}
            }
            mediaPlayer1.setLooping(loop);
            mediaPlayer1.setVolume(vol,vol);
            mediaPlayer1.start();
        }
    }
    public void stop() {
        mediaPlayer1.stop();
        synchronized (this) {
            prepared = false;
        }
    }
    public Music1(AssetFileDescriptor i) {
        mediaPlayer1 = new MediaPlayer();
        prepared = false;
        try {
            mediaPlayer1.setDataSource(i.getFileDescriptor(), i.getStartOffset(),i.getLength());
        } catch (IOException e) { e.printStackTrace(); }
        try { mediaPlayer1.prepare(); } catch (IOException e) { e.printStackTrace(); }
        prepared = true;
    }
}