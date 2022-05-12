package com.ruslan23.game007;

import com.ruslan23.game007.Scene.Load_Of_Res;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Scene1;

public class MainActivity extends Core1 {

    public Scene1 getStartScene() {
        return new Load_Of_Res(this);
    }

}
