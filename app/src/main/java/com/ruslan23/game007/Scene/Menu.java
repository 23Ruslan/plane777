package com.ruslan23.game007.Scene;

import static com.ruslan23.game007.Util.Resources.bitcoin;
import static com.ruslan23.game007.Util.Resources.bitcoin1;
import static com.ruslan23.game007.Util.Resources.readyFont;
import static com.ruslan23.game007.Util.Resources.textureOfSakura;
import static com.ruslan23.game007.Util.Setting.sound;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.ruslan23.game007.R;
import com.ruslan23.game007.Util.Resources;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Scene1;

public class Menu extends Scene1 {
    public Menu(Core1 cor) { super(cor);}
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void update() {
        if(core1.getTouchListenerFW().getTouchUp(20,450,100,50)){ core1.setScene(new Exit(core1));
            if (sound == true) {Resources.soundTouch.play(1);}
        }
        if(core1.getTouchListenerFW().getTouchUp(20,350,100,50)){ core1.setScene(new TopDistances(core1));
            if (sound == true) {Resources.soundTouch.play(1);}
        }
        if(core1.getTouchListenerFW().getTouchUp(20,300,100,50)){ core1.setScene(new Game(core1));
            if (sound == true) {Resources.soundTouch.play(1);}
        }
        if(core1.getTouchListenerFW().getTouchUp(20,400,100,50)){ core1.setScene(new Settings(core1));
            if (sound == true) {Resources.soundTouch.play(1);}
        }
    }
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void drawing() {
        graph1.clearScene(Color.LTGRAY);
        graph1.drawText(core1.getString(R.string.txt_mainMenu_name), 190, 100,Color.BLUE, 60, Resources.mainMenuFont );
        graph1.drawText("tip:",10, 135, Color.GRAY, 20, readyFont);
        graph1.drawText("To get a speed boost during the game, tap the screen.",10, 165, Color.GRAY, 20, readyFont);
        graph1.drawText("After a long press, you have a chance to get a permanent boost.",10, 195, Color.GRAY, 20, readyFont);
        graph1.drawText("And just tap the screen again to deactivate this permanent boost.",10, 225, Color.GRAY, 20, readyFont);

        graph1.drawText(core1.getString(R.string.txt_mainMenu_setting), 20, 400,Color.BLUE, 40, Resources.mainMenuFont );
        graph1.drawText(core1.getString(R.string.txt_mainMenu_exitGame), 20, 450,Color.BLUE, 40, Resources.mainMenuFont );
        graph1.drawTexture(textureOfSakura, 7, 12);
        graph1.drawTexture(bitcoin, 7, 12);
        graph1.drawTexture(bitcoin, 600,100);
        graph1.drawTexture(bitcoin1, 300,250);
        graph1.drawText(core1.getString(R.string.txt_mainMenu_new), 20, 300,Color.BLUE, 40, Resources.mainMenuFont );
        graph1.drawText(core1.getString(R.string.txt_mainMenu_result), 20, 350,Color.BLUE, 40, Resources.mainMenuFont );
    }
    @Override
    public void dispose() {}
}