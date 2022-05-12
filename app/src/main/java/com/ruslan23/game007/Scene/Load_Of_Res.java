package com.ruslan23.game007.Scene;

import static com.ruslan23.game007.Util.Resources.loadingFont;

import android.graphics.Color;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.game007.R;
import com.ruslan23.game007.Task.Loading;
import com.ruslan23.module1.CoreOfGame.Scene1;
import com.ruslan23.game007.Interface.MyListener;

public class Load_Of_Res extends Scene1 implements MyListener {
    private static int progress;
    @Override
    protected void dispose() {}
    @Override
    public void onComplete() {core1.setScene(new Menu(core1));}
    @Override
    protected void update() {}
    @Override
    protected void pause() {}
    @Override
    protected void resume() {}
    @Override
    protected void drawing() {
        core1.getGraphicsFW().clearScene(Color.BLUE);
        core1.getGraphicsFW().drawLine(0,500, progress,500,Color.YELLOW);
        core1.getGraphicsFW().drawText(core1.getString(R.string.load),100,100,Color.YELLOW,50,loadingFont);
    }
    public Load_Of_Res(Core1 cor) {
        super(cor);        progress=0;
        Loading loading = new Loading(cor, this);
        loading.execute();
    }
    public static void setProgressLoader(int progress) {
        Load_Of_Res.progress = progress;
    }
}

