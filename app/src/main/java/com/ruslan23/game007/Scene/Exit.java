package com.ruslan23.game007.Scene;
import android.graphics.Color;

import com.ruslan23.game007.Util.Resources;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Scene1;

public class Exit extends Scene1 {
    public Exit(Core1 cor) {
        super(cor);
    }
    @Override
    protected void dispose() {}
    @Override
    protected void pause() {}
    @Override
    protected void resume() {}
    @Override
    protected void drawing() {
        core1.getGraphicsFW().clearScene(Color.BLACK);
        core1.getGraphicsFW().drawText("NO",150,300, Color.RED,37, Resources.exitFont);
        core1.getGraphicsFW().drawText("YES",150,250, Color.RED,37, Resources.exitFont);
        core1.getGraphicsFW().drawText("Are you sure you want to go out?",50,50, Color.RED,41, Resources.exitFont);
    }
    @Override
    protected void update() {
        if (core1.getTouchListenerFW().getTouchUp(150,300,100,37)){ core1.setScene(new Menu(core1)); }
        if (core1.getTouchListenerFW().getTouchUp(150,250,100,37)){ core1.finish(); }
    }

}
