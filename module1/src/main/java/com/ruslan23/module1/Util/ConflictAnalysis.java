package com.ruslan23.module1.Util;
import com.ruslan23.module1.CoreOfGame.Object1;
public class ConflictAnalysis {
    private static double rad2, rad1, obj1y, obj1x,
            obj2x, obj2y, dy, dx, objDist;
    public static boolean checkConflict(Object1 o1, Object1 o2) {
        obj1y = o1.getHitBox().centerY();
        obj1x = o1.getHitBox().centerX();
        obj2y = o2.getHitBox().centerY();
        obj2x = o2.getHitBox().centerX();
        rad1 = o1.getRadius();
        rad2 = o2.getRadius();
        dy = obj1y - obj2y;
        dx = obj1x - obj2x;
        objDist = Math.sqrt(dy*dy + dx*dx );
        return objDist < (rad1+rad2);
    }
}