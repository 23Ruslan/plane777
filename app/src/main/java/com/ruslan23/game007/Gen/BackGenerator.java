package com.ruslan23.game007.Gen;

import static com.ruslan23.game007.Util.Resources.newYorkTexture;
import static com.ruslan23.game007.Util.Resources.sTextureCloud;

import com.ruslan23.game007.Object.Cloud;
import com.ruslan23.game007.Object.NewYork;
import com.ruslan23.module1.CoreOfGame.Graphics1;

import java.util.ArrayList;

public class BackGenerator {
    private ArrayList<Cloud> cloudArrayList = new ArrayList<>();
    private NewYork newYork;

    public void drawing(Graphics1 graphics1) {
        graphics1.drawTexture(newYorkTexture, newYork.getX(), newYork.getY());
        for (int j = 0; j < cloudArrayList.size(); j++) {
            graphics1.drawTexture(sTextureCloud, cloudArrayList.get(j).getX(),
                    cloudArrayList.get(j).getY());
        }
    }

    public void upd(double speedOfThisPlayer) {
        newYork.update(speedOfThisPlayer);
        for (int j = 0; j < cloudArrayList.size(); j++) {
            cloudArrayList.get(j).update(speedOfThisPlayer);
        }
    }

    public BackGenerator(int allSceneWidth, int allSceneHeight, int minScreenY) {
        newYork = new NewYork(allSceneWidth, allSceneHeight, minScreenY);
        int clouds = 30;
        for (int i = 0; i < clouds; i++) {
            Cloud cloud = new Cloud(allSceneWidth, allSceneHeight, minScreenY);
            cloudArrayList.add(cloud);
        }
    }

}
