package com.ruslan23.game007.Util;
import android.content.SharedPreferences;

import com.ruslan23.module1.CoreOfGame.Core1;
public class Setting {
    public static int[] dist = {8791, 4520, 1325, 889};
    public static boolean sound = true, music = true;
    public static void addDistance(int v) {
        for (int j = 0; j < 3; j++) {
            if (dist[j] <= v) {
                dist[j] = v;
                break;
            }
        }
    }
    public static void save(Core1 cor) {
        SharedPreferences.Editor editor = cor.getSharedPreferences().edit();
        editor.clear();
        editor.putBoolean("musicIsOn", music);
        editor.putBoolean("soundIsOn", sound);
        for (int j = 0; j < 3; ++j) { editor.putInt("distance" + j, dist[j]); }
        editor.apply();
    }
    public static void load(Core1 cor) {
        sound = cor.getSharedPreferences().getBoolean("soundIsOn",true);
        music = cor.getSharedPreferences().getBoolean("musicIsOn",true);
        for (int j = 0; j < 3; j++) {
            dist[j] = cor.getSharedPreferences().getInt("distance" + j, dist[j]);
        }
    }
}