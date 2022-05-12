package com.ruslan23.game007.Object;
import com.ruslan23.module1.CoreOfGame.Object1;

public class NewYork extends Object1 {

    public NewYork (int allSceneWidth, int allSceneHeight, int minY) {
        init(allSceneWidth, allSceneHeight, minY);
    }

    public int getY(){ return y; }
    public int getX(){ return x - 45; }

    private void init(int allSceneWidth, int allSceneHeight, int minY) {
        this.minX = 0; this.minY = minY;
        this.maxX = allSceneWidth; this.maxY = allSceneHeight;
        this.speed = 0.5;
        this.x = 0; this.y = minY;
    }

    public void update (double speedPlayer){
        //x -= speed;
        x -= speedPlayer/10.0;
        if (x < -2300){
            x = 0; y = minY;
        }
    }

}