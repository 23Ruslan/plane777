package com.ruslan23.module1.CoreOfGame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.io.IOException;

public class Graphics1 {
    private Paint paint1;
    private Bitmap frameBuffer1, textureGame1;
    private AssetManager assetManager1;
    private Canvas canvas1;

    public void clearScene(int colorRGB) {
        canvas1.drawRGB(colorRGB, colorRGB, colorRGB);
    }

    public int getWidthFrameBuffer() { return frameBuffer1.getWidth(); }
    public int getHeightFrameBuffer() { return frameBuffer1.getHeight(); }

    public void drawText(String text, int x, int y, int color, int sizeText, Typeface font) {
        paint1.setColor(color);
        paint1.setTextSize(sizeText);
        paint1.setTypeface(font);
        canvas1.drawText(text, x, y, paint1);
    }

    public void drawLine(int startX, int startY, int stopX, int stopY, int color) {
        paint1.setColor(color);
        canvas1.drawLine(startX, startY, stopX, stopY, paint1);
    }

    public Bitmap newTexture(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = assetManager1.open(fileName);
            textureGame1 = BitmapFactory.decodeStream(inputStream);
            if (textureGame1 == null) {throw new RuntimeException("cant load file " + fileName);}
        } catch (IOException e) {throw new RuntimeException("cant load file" + fileName);}
        if (inputStream != null) {
            try {inputStream.close();} catch (IOException e) {e.printStackTrace();}
        }
        return textureGame1;
    }

    public Bitmap newSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite) {
        return Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
    }
    public Graphics1(AssetManager a, Bitmap b) {
        assetManager1 = a;
        frameBuffer1 = b;
        canvas1 = new Canvas(b);
        paint1 = new Paint();
    }
    public void drawTexture(Bitmap textureGame, int x, int y) { canvas1.drawBitmap(textureGame, x, y, null); }
}

