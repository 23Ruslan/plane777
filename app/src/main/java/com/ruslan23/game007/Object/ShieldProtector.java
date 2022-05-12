package com.ruslan23.game007.Object;
import android.graphics.Rect;

import com.ruslan23.game007.Class.ManagerOfGame;
import com.ruslan23.game007.Util.Resources;
import com.ruslan23.module1.CoreOfGame.Animation;
import com.ruslan23.module1.CoreOfGame.Graphics1;
import com.ruslan23.module1.CoreOfGame.Object1;
import com.ruslan23.module1.Util.Rand;

public class ShieldProtector extends Object1 {
    private Animation AnimationOfProtector;

    public void drawing(Graphics1 graphics) {
        AnimationOfProtector.draw(graphics, x, y);
    }

    public ShieldProtector(int maxX, int maxY, int minY) {
        init(maxX, maxY, minY);
    }

    private void init(int max_X, int max_Y, int min_Y) {
        this.maxX = max_X;
        this.minY = min_Y;
        this.minX = 0;
        this.maxY = max_Y - Resources.protectorSprite.get(0).getHeight();
        y = Rand.getGap(min_Y, max_Y);
        x = max_X;
        rad = Resources.protectorSprite.get(0).getWidth() / 2;
        hitbox = new Rect(x, y, Resources.protectorSprite.get(0).getWidth(),
                Resources.protectorSprite.get(0).getHeight());
        AnimationOfProtector = new Animation(ManagerOfGame.ANIMATION_SPEED,
                Resources.protectorSprite.get(0), Resources.protectorSprite.get(1),
                Resources.protectorSprite.get(2), Resources.protectorSprite.get(3));
    }

    public void upd(double speedOfMainPlayer) {
        x -= speed;
        x -= speedOfMainPlayer;
        if (x < minX) { y = Rand.getGap(minY, maxY); }
        AnimationOfProtector.run();
        hitbox = new Rect(x, y, Resources.enemySprite.get(0).getWidth(),
                Resources.enemySprite.get(0).getHeight());
    }
}