package com.ruslan23.game007.Object;
import static com.ruslan23.game007.Util.Resources.bitcoin2;
import static com.ruslan23.game007.Util.Resources.hudFont;

import android.graphics.Color;

import com.ruslan23.game007.R;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Graphics1;

public class UpperHorizontalBar_Hud {
    public static int dist;
    private int shields_now, speed_now;

    private final int hud_Y = 49;
    private final Core1 CORE;
    public void drawing(Graphics1 graph){
        graph.drawTexture(bitcoin2, 417,3);
        graph.drawText(CORE.getString(R.string.txt_hud_shields)+": "+ ((shields_now >= 0) ? (shields_now) : 0),465,30,Color.RED,25,hudFont);
        graph.drawLine(0, hud_Y, graph.getWidthFrameBuffer(), hud_Y, Color.DKGRAY);
        graph.drawText(CORE.getString(R.string.txt_hud_passed)+": "+ dist,125,30,Color.RED,25, hudFont);
        graph.drawText(CORE.getString(R.string.txt_hud_speed)+": "+ speed_now,5,30,Color.RED,25, hudFont);
    }

    public int getHud_Y() {
        return hud_Y;
    }

    public void upd(int dist, int currentSpeedPlayer, int currentShieldsPlayer) {
        this.speed_now = currentSpeedPlayer;
        this.dist = dist;
        this.shields_now = currentShieldsPlayer;
    }

    public UpperHorizontalBar_Hud(Core1 core1) {
        this.CORE = core1;
    }

}