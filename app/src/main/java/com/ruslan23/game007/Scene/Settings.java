package com.ruslan23.game007.Scene;

import static com.ruslan23.game007.Util.Resources.bitcoin1;
import static com.ruslan23.game007.Util.Resources.settingsFont;

import android.graphics.Color;

import com.ruslan23.module1.CoreOfGame.Scene1;
import com.ruslan23.game007.Util.Setting;
import com.ruslan23.module1.CoreOfGame.Core1;

public class Settings extends Scene1 {
    Settings(Core1 cor) {
        super(cor);
    }
    @Override
    protected void resume() {}
    @Override
    protected void pause() {}
    @Override
    protected void dispose() {}
    @Override
    protected void update() {
        if (core1.isPressedKeyBack() == true){
            core1.setPressedKeyBack(false);
            core1.setScene(new Menu(core1));
        }
        if (core1.getTouchListenerFW().getTouchUp(405,355,105,31)){
            Setting.music = !Setting.music;
            Setting.save(core1);
        }
        if (core1.getTouchListenerFW().getTouchUp(405,305,105,45)){
            Setting.sound = !Setting.sound;
            Setting.save(core1);
        }
    }
    @Override
    protected void drawing() {
        core1.getGraphicsFW().clearScene(Color.LTGRAY);
        graph1.drawTexture(bitcoin1, 120,250);
        core1.getGraphicsFW().drawText("MUSIC ",250, 355, Color.DKGRAY, 31, settingsFont);
        core1.getGraphicsFW().drawText("SOUND ",250, 305, Color.DKGRAY, 31, settingsFont);
        core1.getGraphicsFW().drawText("SETTINGS",250, 200, Color.DKGRAY, 39, settingsFont);

        if (Setting.sound == true){
            core1.getGraphicsFW().drawText("ON    ",405, 305, Color.DKGRAY, 31, settingsFont);
        } else core1.getGraphicsFW().drawText("OFF   ",405, 305, Color.RED, 31, settingsFont);
        if (Setting.music == true){
            core1.getGraphicsFW().drawText("ON    ",405, 355, Color.DKGRAY, 30, settingsFont);
        } else core1.getGraphicsFW().drawText("OFF    ",405, 355, Color.RED, 30, settingsFont);
    }
}
