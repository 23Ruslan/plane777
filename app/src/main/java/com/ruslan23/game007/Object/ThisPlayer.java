package com.ruslan23.game007.Object;
import static com.ruslan23.game007.Util.Setting.sound;

import android.graphics.Rect;
import com.ruslan23.game007.Class.ManagerOfGame;
import com.ruslan23.game007.Util.Resources;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Graphics1;
import com.ruslan23.module1.CoreOfGame.Object1;
import com.ruslan23.module1.Util.Delay;
import com.ruslan23.module1.CoreOfGame.Animation;

public class ThisPlayer extends Object1 {

    private final int maximalSpeed = 17, gravity = -4, minimalSpeed = 2;
    private Animation animationOfBoost, hitAnimation, explosionAnimation,
            shieldsAnimation, shieldsWithBoost, animationOfThisPlayer;
    private Delay timerOfShieldsOn, timerOfShieldHit, timerGameOver;
    private static boolean shield;
    private Core1 core;
    public static boolean hit;
    private boolean boost, gameOver;
    private int shields;

    public void update() {
        if (core.getTouchListenerFW().getTouchDown(0, maxY, maxX, maxY)) {
            startBoosting();
        }
        if (core.getTouchListenerFW().getTouchUp(0, maxY, maxX, maxY)) {
            stopBoosting();
        }
        if (shield == true & timerOfShieldsOn.timerDelay(7)) { shield = false; }
        updateBoosting();
        hitbox = new Rect(x, y,
                Resources.spriteOfPlayer.get(0).getWidth(),
                Resources.spriteOfPlayer.get(0).getHeight());
        if (gameOver == true) { explosionAnimation.run(); }
        if (hit == true) { explosionAnimation.run(); }
    }

    public ThisPlayer(Core1 core1, int maxX, int maxY, int minY) {
        init(core1, maxX, maxY, minY); initAnimation();
    }

    public void drawing(Graphics1 graphics1) {
        if (gameOver == true) {
            explosionAnimation.draw(graphics1, x, y);
            if (timerGameOver.timerDelay(1.5) == true) { ManagerOfGame.gameOver = true; }
        }
        if (hit==true) {
            hitAnimation.draw(graphics1, x, y);
            if (timerOfShieldHit.timerDelay(1.5) == true) { hit = false; }
        }
        if (boost==true) {
            if (shield == true) {
                shieldsWithBoost.draw(graphics1, x, y);
            } else animationOfBoost.draw(graphics1, x, y);
        } else if (shield == true) {
            shieldsAnimation.draw(graphics1, x, y);
        } else animationOfThisPlayer.draw(graphics1, x, y);
    }

    public void hitEnemy() {
        if (shield==false) {
            shields=shields-1;
            if (shields < 0) {
                if (sound == true) {Resources.explode.play(1);}
                gameOver = true; timerGameOver.startTimer();
            }
            hit = true; timerOfShieldHit.startTimer();
        }
    }

    public void hitProtector() {
        shield = true;
        ++shields;
        timerOfShieldsOn.startTimer();
    }

    private void stopBoosting() {
        boost=false;
    }
    private void startBoosting() {
        boost=true;
    }
    public double getSpeedPlayer() {
        return speed;
    }
    public int getShieldsPlayer() {
        return shields;
    }
    public static boolean isShieldsOn() {
        return shield;
    }

    private void initAnimation() {
        explosionAnimation = new Animation(speed,
                Resources.spriteOfExplosion.get(0), Resources.spriteOfExplosion.get(1),
                Resources.spriteOfExplosion.get(2), Resources.spriteOfExplosion.get(3));
        shieldsAnimation = new Animation(speed,
                Resources.spriteOfShieldsOn.get(0), Resources.spriteOfShieldsOn.get(1),
                Resources.spriteOfShieldsOn.get(2), Resources.spriteOfShieldsOn.get(3));
        animationOfThisPlayer = new Animation(speed,
                Resources.spriteOfPlayer.get(0), Resources.spriteOfPlayer.get(1),
                Resources.spriteOfPlayer.get(2), Resources.spriteOfPlayer.get(3));
        animationOfBoost = new Animation(speed,
                Resources.SpriteOfBoost.get(0), Resources.SpriteOfBoost.get(1),
                Resources.SpriteOfBoost.get(2), Resources.SpriteOfBoost.get(3));
        shieldsWithBoost = new Animation(speed,
                Resources.spriteShieldsBoost.get(0), Resources.spriteShieldsBoost.get(1),
                Resources.spriteShieldsBoost.get(2), Resources.spriteShieldsBoost.get(3));
        hitAnimation = new Animation(speed,
                Resources.spriteOfExplosion.get(0), Resources.spriteOfExplosion.get(1),
                Resources.spriteOfExplosion.get(2), Resources.spriteOfExplosion.get(3));
    }

    private void updateBoosting() {
        if (boost) {
            speed = speed + 0.3;
        } else speed = speed - 3;
        if (speed > maximalSpeed) { speed = maximalSpeed; }
        if (speed < minimalSpeed) { speed = minimalSpeed; }
        y -= speed + gravity;
        if (y < minY) { y = minY; }
        if (y > maxY) { y = maxY; }
        if (boost==true) {
            if (shield==true) {
                shieldsWithBoost.run();
            } else animationOfBoost.run();
        } else if (shield==true) {
            shieldsAnimation.run();
        } else animationOfThisPlayer.run();
    }

    private void init(Core1 core1, int maxX, int maxY, int minY) {
        shield = false;
        y = 100;
        x = 20;
        speed = ManagerOfGame.ANIMATION_SPEED;
        shields = 2;
        boost = false;
        hit = false;
        gameOver = false;
        rad = Resources.spriteOfPlayer.get(0).getWidth()/5;
        timerGameOver = new Delay();
        timerOfShieldsOn = new Delay();
        timerOfShieldHit = new Delay();
        this.minY = minY; this.core = core1;
        this.maxX = maxX; this.maxY = maxY - Resources.spriteOfPlayer.get(0).getHeight();
    }
}