package com.ruslan23.module1.CoreOfGame;


import android.graphics.Point;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.view.Display;
import android.content.SharedPreferences;
import android.view.WindowManager;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

public class Core1 extends AppCompatActivity {

    private final float FRAMEBUFFER_HEIGHT = 600, FRAMEBUFFER_WIDTH = 800;
    private Display display1;
    private Bitmap frameBuffer;
    private Audio audio1;
    private Point displaySize;
    private Scene1 scene1;
    private float scHeight, scWidth;
    private Listener1 listener1;
    private MainLoop loop1;
    private Graphics1 graphics1;
    private SharedPreferences sharedPreferences1;
    private final String SETTINGS = "settings";
    private boolean pressedBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        init(); setContentView(loop1);
    }

    public Listener1 getTouchListenerFW() {
        return listener1;
    }
    public Graphics1 getGraphicsFW() {
        return graphics1;
    }
    public void onResume() {
        super.onResume(); scene1.resume();
        loop1.startGame();
    }

    public void onPause() {
        super.onPause();
        scene1.pause();
        loop1.stopGame();
        if (isFinishing()) { scene1.dispose(); }
    }

    public boolean onKeyDown(int cod, KeyEvent event) {
        if (cod == KeyEvent.KEYCODE_BACK) {
            pressedBack = true;
            return true;
        }
        return false;
    }
    public void setPressedKeyBack(boolean i) {
        this.pressedBack = i;
    }
    public boolean isPressedKeyBack() {return pressedBack;}


    public void setScene(Scene1 sc) {
        if (sc == null) { throw new IllegalArgumentException("cant load scene"); }
        this.scene1.pause();
        this.scene1.dispose();
        sc.resume();
        sc.update();
        this.scene1 = sc;
    }
    private void init() {
        sharedPreferences1 = getSharedPreferences(SETTINGS, MODE_PRIVATE);
        displaySize = new Point();
        display1 = getWindowManager().getDefaultDisplay();
        display1.getSize(displaySize);
        frameBuffer = Bitmap.createBitmap((int) FRAMEBUFFER_WIDTH, (int) FRAMEBUFFER_HEIGHT, Bitmap.Config.ARGB_8888);
        scHeight = FRAMEBUFFER_HEIGHT/displaySize.y;
        scWidth = FRAMEBUFFER_WIDTH/displaySize.x;
        audio1 = new Audio(this);
        loop1 = new MainLoop(this, frameBuffer);
        listener1 = new Listener1(loop1, scWidth, scHeight);
        graphics1 = new Graphics1(getAssets(), frameBuffer);
        scene1 = getStartScene();
        pressedBack = false;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences1;
    }
    public Audio getAudioFW() { return audio1; }
    public Scene1 getCurrentScene() {
        return scene1;
    }
    public Scene1 getStartScene() {
        return scene1;
    }

}