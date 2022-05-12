package com.ruslan23.module1.CoreOfGame;
import android.graphics.Bitmap;

public class Animation {
    private Bitmap sprite4, sprite3, sprite, sprite1, sprite2;
    private int numberOfFrames, delay, frames;
    private double speedOfAnim;

    public Animation(double speed, Bitmap sprite1, Bitmap sprite2, Bitmap sprite3, Bitmap sprite4) {
        sprite = sprite1; speedOfAnim = speed;
        this.sprite1 = sprite1; this.sprite2 = sprite2;
        this.sprite3 = sprite3; this.sprite4 = sprite4;
        frames = 4;
    }

    public void draw(Graphics1 i, int x, int y) {
        i.drawTexture(sprite, x, y);
    }

    private void next() {
        if (numberOfFrames == 0) { sprite = sprite1; }
        if (numberOfFrames == 1) { sprite = sprite2; }
        if (numberOfFrames == 2) { sprite = sprite3; }
        if (numberOfFrames == 3) { sprite = sprite4; }
        ++numberOfFrames;
        if (numberOfFrames > frames) { numberOfFrames = 0; }
    }
    public void run() {
        ++delay;
        if (delay > speedOfAnim) {
            delay = 0;
            next();
        }
    }
}