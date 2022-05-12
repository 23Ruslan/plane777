package com.ruslan23.module1.Util;

public class Delay {
    private final double sec = 1000000000;
    private double start, elapsed, now;
    public boolean timerDelay(double second) {
        now = System.nanoTime() / sec;
        elapsed = now - start;
        return elapsed > second;
    }
    public void startTimer() {
        start = System.nanoTime()/sec;
    }
}
