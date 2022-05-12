package com.ruslan23.game007.Gen;
import static com.ruslan23.game007.Object.UpperHorizontalBar_Hud.dist;
import com.ruslan23.game007.Object.AllEnemies;
import com.ruslan23.module1.CoreOfGame.Graphics1;

import java.util.ArrayList;

public class EnemiesGenerator {

    private int minY, maxX, maxY, enemyType;
    private ArrayList<AllEnemies> enemiesArrayList_number3, enemiesArrayList_number2, enemiesArrayList;

    public EnemiesGenerator(int allSceneWidth, int allSceneHeight, int minY) {
        init(allSceneWidth, allSceneHeight, minY);
    }

    public void drawing(Graphics1 graphics1) {
        for (int j = 0; j < enemiesArrayList.size(); j++) {
            enemiesArrayList.get(j).draw(graphics1);
        }
    }

    private void init(int allSceneWidth, int allSceneHeight, int minY) {
        this.maxY = allSceneHeight; this.minY = minY; this.maxX = allSceneWidth;
        enemiesArrayList_number2 = new ArrayList<>();
        enemiesArrayList_number3 = new ArrayList<>();
        enemiesArrayList = new ArrayList<>();
    }

    public void update(double speedOfThisPlayer) {
        if (enemiesArrayList.size() < (dist % 3000) / 500) { addEnemy(1); }//each 500 dist is plus 1 enemy, but 6 is max
        for (int j = 0; j < enemiesArrayList.size(); j++) {
            enemiesArrayList.get(j).update(speedOfThisPlayer);
        }
    }

    public ArrayList<AllEnemies> getEnemyArrayList() {
        return enemiesArrayList;
    }

    private void addEnemy(int count) {
        for (int j = 0; j < count; j++) {
            enemiesArrayList.add(new AllEnemies(maxX, maxY, minY, 1 + (dist / 2000) % 3)) ;
        }
    }

    public void hitPlayer(AllEnemies enemy1) {
        for (int j = 0; j < enemiesArrayList.size(); j++) { enemiesArrayList.remove(enemy1); }
    }

}

