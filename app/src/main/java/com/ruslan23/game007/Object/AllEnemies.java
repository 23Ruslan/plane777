package com.ruslan23.game007.Object;

import android.graphics.Rect;

import com.ruslan23.game007.Util.Resources;
import com.ruslan23.module1.CoreOfGame.Animation;
import com.ruslan23.module1.CoreOfGame.Graphics1;
import com.ruslan23.module1.CoreOfGame.Object1;
import com.ruslan23.module1.Util.Rand;

public class AllEnemies extends Object1 {

    private Animation AnimationEnemy;

    public AllEnemies(int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {
        init(maxScreenX, maxScreenY, minScreenY);
        initTypeOfThisEnemy(enemyType);
    }

    private void init(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxX = maxScreenX;
        this.maxY = maxScreenY - Resources.enemySprite.get(0).getHeight();
        this.minY = minScreenY;
        this.minX = 0;
        x = maxScreenX;
        y = Rand.getGap(minScreenY, maxScreenY);
        rad = Resources.enemySprite.get(0).getWidth()/4;
    }

    public void update(double speedPlayer) {
        x -= speed;
        x -= speedPlayer;
        if (x < minX) {
            x = maxX;
            y = Rand.getGap(minY, maxY);
        }

        AnimationEnemy.run();

        hitbox = new Rect(x, y,
                Resources.enemySprite.get(0).getWidth(),
                Resources.enemySprite.get(0).getHeight());
    }

    public void draw(Graphics1 i) {
        AnimationEnemy.draw(i, x, y);
    }

    private void initTypeOfThisEnemy(int enemyType) {
        switch (enemyType) {
            case 1:
                speed = Rand.getGap(1, 6);
                AnimationEnemy = new Animation(5,
                        Resources.enemySprite.get(0), Resources.enemySprite.get(1),
                        Resources.enemySprite.get(2), Resources.enemySprite.get(3));
                break;
            case 2:
                speed = Rand.getGap(3, 8);
                AnimationEnemy = new Animation(5,
                        Resources.enemySprite2.get(0), Resources.enemySprite2.get(1),
                        Resources.enemySprite2.get(2), Resources.enemySprite2.get(3));
                break;
            case 3:
                speed = Rand.getGap(4, 9);
                AnimationEnemy = new Animation(5,
                        Resources.enemySprite3.get(0), Resources.enemySprite3.get(1),
                        Resources.enemySprite3.get(2), Resources.enemySprite3.get(3));
                break;
        }
    }
}