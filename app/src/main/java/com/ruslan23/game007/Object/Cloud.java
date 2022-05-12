package com.ruslan23.game007.Object;
import com.ruslan23.module1.Util.Rand;
import com.ruslan23.module1.CoreOfGame.Object1;

public class Cloud extends Object1 {

    public Cloud(int allSceneWidth, int allSceneHeight, int minY) {
        init(allSceneWidth, allSceneHeight, minY);
    }

    public int getY(){ return y; }
    public int getX(){ return x - 45; }

    private void init(int allSceneWidth, int allSceneHeight, int minY) {
        this.minX = 0; this.minY = minY;
        this.maxX = allSceneWidth; this.maxY = allSceneHeight;
        this.speed = 2.5;
        this.x = Rand.getCasualNumber(maxX); this.y = Rand.getGap(minY, maxY);
    }

    public void update (double speedPlayer){
        x -= speed;
        x -= speedPlayer;
        if (x < 0){
            x = maxX; y = Rand.getGap(minY, maxY);
        }
    }

}
