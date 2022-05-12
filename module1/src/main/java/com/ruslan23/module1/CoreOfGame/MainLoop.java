package com.ruslan23.module1.CoreOfGame;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Canvas;
import java.util.Date;

public class MainLoop extends SurfaceView implements Runnable {
    private Thread gameThread = null;
    private Canvas canvas1;
    private Rect rect1;
    private Core1 core1;
    private SurfaceHolder surfaceHolder1;
    private Bitmap frameBuffer1;
    private long timer = 0;
    private float draw, updates = 0;
    private final float sec = 1000000000, fps = 40, updTime = sec / fps;
    private boolean run = false;

    @Override
    public void run() {
        float d = 0, last = System.nanoTime();
        timer = System.currentTimeMillis();
        while (run == true) {
            float now = System.nanoTime(), elapsed = now-last;
            last = now;
            d += elapsed/updTime;
            if (d>1) { updateGame(); drawingGame(); --d; }
            if (System.currentTimeMillis() - timer > 1000) {
                Date date = new Date();
                //println - to test performance
                //System.out.println("draw " + draw + " upd = " + updates + " " + date.toString());
                updates = 0; draw = 0;
                timer += 1000;
            }
        }
    }
    public void stopGame() {
        if (run == false) { return; }
        run = false;
        try {gameThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }
    private void updateGame() {
        ++updates;
        core1.getCurrentScene().update();
    }
    public void startGame() {
        if (run == true) {return;}
        run = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    private void drawingGame() {
        ++draw;
        if (surfaceHolder1.getSurface().isValid() == true) {
            canvas1 = surfaceHolder1.lockCanvas();
            canvas1.getClipBounds(rect1);
            canvas1.drawBitmap(frameBuffer1, null, rect1, null);
            core1.getCurrentScene().drawing();
            surfaceHolder1.unlockCanvasAndPost(canvas1);
        }
    }
    public MainLoop(Core1 cor, Bitmap frBuff) {
        super(cor);
        frameBuffer1 = frBuff;
        this.core1 = cor;
        surfaceHolder1 = getHolder();
        rect1 = new Rect();
        canvas1 = new Canvas();
    }
}
