package com.ruslan23.module1.Util;
import java.util.Random;
public class Rand {
    public static int getCasualNumber(int m){
        Random random = new Random();
        return random.nextInt(m);
    }
    public static int getGap(int min, int max){
        return (int)(min + (Math.random() * ++max));
    }
}
