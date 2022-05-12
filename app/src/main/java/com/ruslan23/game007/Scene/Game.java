package com.ruslan23.game007.Scene;
import static com.ruslan23.game007.Util.Resources.gameOverFont;
import static com.ruslan23.game007.Util.Resources.pauseFont;
import static com.ruslan23.game007.Util.Resources.readyFont;

import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;
import com.ruslan23.game007.R;
import com.ruslan23.game007.Class.ManagerOfGame;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.game007.Util.Resources;
import com.ruslan23.game007.Util.Setting;
import com.ruslan23.module1.CoreOfGame.Scene1;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Game extends Scene1 {

    private ManagerOfGame manager;
    private GameState state;

    enum GameState {RUNNING, READY, GAME_OVER, PAUSE}

    private void init(Core1 core1) {
        manager = new ManagerOfGame(core1, scWidth, scHeight);
        state = GameState.READY;
    }
    public Game(Core1 cor) {
        super(cor); init(cor);
        if (Setting.music == true){ Resources.musicOfGame.play(true, 0.5f); }
    }

    @Override
    public void update() {
        if (state == GameState.RUNNING) { updRunning();}
        if (state == GameState.PAUSE) { updPause();}
        if (state == GameState.READY) { updReady();}
        if (state == GameState.GAME_OVER) { updGameOver();}
    }

    private void updReady() {
        if (core1.getTouchListenerFW().getTouchUp(0, scHeight, scWidth, scHeight)) {state = GameState.RUNNING;}
    }

    @Override
    public void drawing() {
        graph1.clearScene(Color.BLACK);
        if (state == GameState.PAUSE) {
            drawPause();}
        if (state == GameState.GAME_OVER) {drawGameOver();}
        if (state == GameState.READY) {drawingStateReady();}
        if (state == GameState.RUNNING) {
            drawRunning();}
    }

    private void drawGameOver() {
        graph1.clearScene(Color.BLACK);
        graph1.drawText(core1.getString(R.string.txt_gameScene_gameOver_exitToMenu), 240, 420, Color.YELLOW, 30, gameOverFont);
        graph1.drawText(core1.getString(R.string.txt_gameScene_gameOver_distance) + ": " + manager.getPassedDistance(), 240, 200, Color.YELLOW, 30, gameOverFont);
        graph1.drawText(core1.getString(R.string.txt_gameScene_GameOver_gameOver), 240, 300, Color.YELLOW, 60, gameOverFont);
        graph1.drawText(core1.getString(R.string.txt_gameScene_GameOver_restart), 240, 360, Color.YELLOW, 30, gameOverFont);

        graph1.drawText("tip:",13, 467, Color.GREEN, 25, readyFont);
        graph1.drawText("First, rest for five seconds, and then make your choice.",13, 507, Color.GREEN, 25, readyFont);
        graph1.drawText("The button may not be pressed the first time, but you try to press it!",13, 547, Color.GREEN, 25, readyFont);
        graph1.drawText("Because in the pursuit of bitcoin, it is important to try and work hard!",13, 587, Color.GREEN, 25, readyFont);
    }

    private void updGameOver() {
        Setting.addDistance(manager.getPassedDistance());
        if (core1.getTouchListenerFW().getTouchUp(240, 420, 300, 50)) {core1.setScene(new Menu(core1));}
        if (core1.getTouchListenerFW().getTouchUp(240, 360, 100, 50)) {core1.setScene(new Game(core1));}
    }

    private void updPause() {
        if (core1.getTouchListenerFW().getTouchUp(0, scHeight, scWidth, scHeight)) {state = GameState.RUNNING;}
    }

    private void drawRunning() {
        graph1.clearScene(0xFA8072);
        manager.drawing(graph1);
    }

    private void updRunning() {
       drawRunning();
        manager.update();
        if (core1.isPressedKeyBack()){
            state = GameState.PAUSE;
            core1.setPressedKeyBack(false);
        }
        if (ManagerOfGame.gameOver) {state = GameState.GAME_OVER;}
    }

    @Override
    public void dispose() {}

    private void drawPause() {core1.getGraphicsFW().drawText("PAUSE", 169,297, Color.RED,64,pauseFont); }

    private void drawingStateReady() {
        graph1.clearScene(Color.LTGRAY);
        graph1.drawText(core1.getString(R.string.txt_gameScene_ready),250, 300, Color.WHITE, 64, readyFont);
    }

    @Override
    public void pause() {
        Resources.musicOfGame.stop();
    }

    @Override
    public void resume() {if (Setting.music == true){Resources.musicOfGame.play(true,0.5f);}}
}