package com.ruslan23.game007.Class;

import static com.ruslan23.game007.Util.Setting.sound;

import com.ruslan23.game007.Gen.BackGenerator;
import com.ruslan23.game007.Gen.EnemiesGenerator;
import com.ruslan23.game007.Gen.GiftGenerator;
import com.ruslan23.game007.Object.UpperHorizontalBar_Hud;
import com.ruslan23.game007.Object.ThisPlayer;
import com.ruslan23.game007.Util.Resources;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Graphics1;
import com.ruslan23.module1.Util.ConflictAnalysis;

public class ManagerOfGame {
    private UpperHorizontalBar_Hud Hud;
    private EnemiesGenerator GeneratorOfEnemy;
    private GiftGenerator GeneratorOfGifts;
    private BackGenerator GeneratorOfBackground;
    private ThisPlayer mainPlayer;
    public static boolean gameOver;
    private int myPassedDistance, currentSpeedOfPlayer, currentShieldsOfPlayer;
    public final static double ANIMATION_SPEED = 3.7;

    public void drawing(Graphics1 graphics1) {
        Hud.drawing(graphics1);
        GeneratorOfBackground.drawing(graphics1);
        mainPlayer.drawing(graphics1);
        GeneratorOfGifts.drawing(graphics1);
        GeneratorOfEnemy.drawing(graphics1);
    }

    public void update() {
        updateObjects();
        myPassedDistance += mainPlayer.getSpeedPlayer();
        currentShieldsOfPlayer = mainPlayer.getShieldsPlayer();
        currentSpeedOfPlayer = (int) mainPlayer.getSpeedPlayer() * 30;
        checkHit();
    }

    private void init(Core1 myCore1, int allSceneWidth, int allSceneHeight) {
        Hud = new UpperHorizontalBar_Hud(myCore1);
        int MinimalScreenY = Hud.getHud_Y();
        GeneratorOfGifts = new GiftGenerator(allSceneWidth, allSceneHeight, MinimalScreenY);
        GeneratorOfEnemy = new EnemiesGenerator(allSceneWidth, allSceneHeight, MinimalScreenY);
        mainPlayer = new ThisPlayer(myCore1, allSceneWidth, allSceneHeight, MinimalScreenY);
        GeneratorOfBackground = new BackGenerator(allSceneWidth, allSceneHeight, MinimalScreenY);
        gameOver = false;
    }

    public ManagerOfGame(Core1 myCore1, int allSceneWidth, int allSceneHeight) {
        init(myCore1, allSceneWidth, allSceneHeight);
    }

    private void checkHit() {
        for (int i = 0; i < GeneratorOfEnemy.getEnemyArrayList().size(); i++) {
            if (ConflictAnalysis.checkConflict(mainPlayer, GeneratorOfEnemy
                    .getEnemyArrayList().get(i)) == true) { if (sound == true) {Resources.hitSound.play(1);}
                mainPlayer.hitEnemy();
                GeneratorOfEnemy.hitPlayer(GeneratorOfEnemy.getEnemyArrayList().get(i));
            }
        }
        if (ConflictAnalysis.checkConflict(mainPlayer, GeneratorOfGifts.getProtector())) {
            hitPlayerWithProtector();
        }
    }

    private void updateObjects() {
        GeneratorOfBackground.upd(mainPlayer.getSpeedPlayer());
        mainPlayer.update();
        GeneratorOfEnemy.update(mainPlayer.getSpeedPlayer());
        GeneratorOfGifts.update(mainPlayer.getSpeedPlayer());
        Hud.upd(myPassedDistance, currentSpeedOfPlayer, currentShieldsOfPlayer);
    }

    private void hitPlayerWithProtector() {
        mainPlayer.hitProtector();
        GeneratorOfGifts.hitProtectorWithPlayer();
    }

    public int getPassedDistance() {
        return myPassedDistance;
    }
}