package com.ruslan23.module1.CoreOfGame;
import android.view.View;
import android.view.MotionEvent;

public class Listener1 implements View.OnTouchListener {
    private boolean touchUp, touchDown;
    private float touchy, touchx, scHeight, scWidth;

    public Listener1(View view, float w, float h) {
        view.setOnTouchListener(this);
        scWidth = w; scHeight = h;
    }

    public boolean getTouchDown(int x, int y, int w, int h) {
        if (touchDown) {
            if (touchx >= x && touchx <= x+w-1 && touchy <= y && touchy >= y-(h-1)) {
                touchDown = false;
                return true;
            }
        }
        return false;
    }
    public boolean getTouchUp(int x, int y, int w, int h) {
        if (touchUp) {
            if (touchx >= x && touchx <= x+w-1 && touchy <= y && touchy >= y-(h-1)) {
                touchUp = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        synchronized (this) {
            touchDown = false;
            touchUp = false;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchy = event.getY() * scHeight;
                    touchx = event.getX() * scWidth;
                    touchDown = true;
                    touchUp = false;
                    break;
                case MotionEvent.ACTION_UP:
                    touchy = event.getY() * scHeight;
                    touchx = event.getX() * scWidth;
                    touchDown = false;
                    touchUp = true;
                    break;
            }
        }
        return true;
    }
}