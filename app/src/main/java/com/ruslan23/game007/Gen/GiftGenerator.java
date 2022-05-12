package com.ruslan23.game007.Gen;
import com.ruslan23.game007.Object.ShieldProtector;
import com.ruslan23.game007.Object.ThisPlayer;
import com.ruslan23.module1.CoreOfGame.Graphics1;
import com.ruslan23.module1.Util.Delay;

public class GiftGenerator {
    private ShieldProtector shield;
    private int maxY, minX, maxX, minY;
    private Delay t;

    public GiftGenerator(int allSceneWidth, int allSceneHeight, int minY) {
        init(allSceneWidth, allSceneHeight, minY);
    }

    public void update(double speedPlayer) {

        if (!ThisPlayer.isShieldsOn() )//&& (t.timerDelay(0.2)))
         {
            shield.upd(speedPlayer);
            if (shield.getX() < minX) {
                shield = null;
                shield = new ShieldProtector(maxX, maxY, minY);
                //t.startTimer();
            }
        }
    }

    public ShieldProtector getProtector() {
        return shield;
    }

    private void init(int allSceneWidth, int allSceneHeight, int minY) {
        this.maxX = allSceneWidth; this.minY = minY;
        this.minX = 0; this.maxY = allSceneHeight;
        shield = new ShieldProtector(maxX, maxY, minY);
        //t = new Delay();
        //t.startTimer();
    }

    public void drawing(Graphics1 graphics1) {
        shield.drawing(graphics1);
    }

    public void hitProtectorWithPlayer() {
        shield = null;
        shield = new ShieldProtector(maxX, maxY, minY);
       // t.startTimer();
    }
}