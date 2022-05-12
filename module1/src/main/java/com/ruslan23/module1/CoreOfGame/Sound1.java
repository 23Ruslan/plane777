package com.ruslan23.module1.CoreOfGame;
import android.media.SoundPool;
public class Sound1 {
    private SoundPool soundPool1;
    private int s;
    public void  play(float vol){
        soundPool1.play(s,vol,vol,0,0,1);
    }
    public Sound1(int s, SoundPool i) {
        this.soundPool1 = i;
        this.s = s;
    }
}
