package com.ruslan23.module1.CoreOfGame;
import android.graphics.Rect;
public abstract class Object1 {
    protected Rect hitbox;
    protected int y, x, maxY, maxX, minX, minY;
    protected double rad, speed;
    public Rect getHitBox() {
        return hitbox;
    }
    public int getY() {
        return y;
    }
    public double getRadius() {
        return rad;
    }
    public int getX() {return x;}
}