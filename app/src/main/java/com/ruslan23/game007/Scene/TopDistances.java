package com.ruslan23.game007.Scene;

import static com.ruslan23.game007.Util.Resources.bitcoin1;
import static com.ruslan23.game007.Util.Resources.readyFont;
import static com.ruslan23.game007.Util.Resources.resultsFont;

import android.graphics.Color;

import com.ruslan23.game007.R;
import com.ruslan23.game007.Util.Setting;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Scene1;

public class TopDistances extends Scene1 {
    TopDistances(Core1 cor) { super(cor);}
    private static String[] numb = new String[3];
    @Override
    public void update() {
        if (core1.getTouchListenerFW().getTouchUp(0, scHeight, scWidth, scHeight)) {core1.setScene(new Menu(core1));}
    }
    @Override
    public void dispose() {}
    @Override
    public void pause() {}
    @Override
    public void drawing() {
        for (int j = 0; j < 3; ++j) {numb[j] = " " + (1+j) + "." + Setting.dist[j];}
        graph1.drawTexture(bitcoin1, 470,250);
        graph1.drawText(core1.getString(R.string.txt_top_distances), 115, 190, Color.RED, 40, resultsFont);
        graph1.drawText(String.valueOf(numb[0]), 144, 300, Color.YELLOW, 41, resultsFont);
        graph1.drawText(String.valueOf(numb[1]), 144, 350, Color.YELLOW, 41, resultsFont);
        graph1.drawText(String.valueOf(numb[2]), 144, 400, Color.YELLOW, 41, resultsFont);
        graph1.drawText("tip:",100, 507, Color.GRAY, 25, readyFont);
        graph1.drawText("Tap anywhere on the screen to leave the high scores menu!",100, 535, Color.GRAY, 25, readyFont);


    }
    @Override
    public void resume() {graph1.clearScene(Color.LTGRAY);}
}