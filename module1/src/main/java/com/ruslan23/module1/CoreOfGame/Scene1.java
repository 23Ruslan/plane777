package com.ruslan23.module1.CoreOfGame;
public abstract class Scene1 {
    protected Graphics1 graph1;
    protected Core1 core1;
    protected int scHeight, scWidth;
    protected abstract void update();
    protected abstract void resume();
    protected abstract void dispose();
    protected abstract void drawing();
    protected abstract void pause();
    protected Scene1(Core1 i) {
        this.core1 = i;
        graph1 = i.getGraphicsFW();
        scHeight = i.getGraphicsFW().getHeightFrameBuffer();
        scWidth = i.getGraphicsFW().getWidthFrameBuffer();
    }
}
