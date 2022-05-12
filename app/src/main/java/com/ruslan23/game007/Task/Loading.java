package com.ruslan23.game007.Task;

import android.os.AsyncTask;
import android.os.Build;

import androidx.core.content.res.ResourcesCompat;

import com.ruslan23.game007.R;
import com.ruslan23.game007.Scene.Load_Of_Res;
import com.ruslan23.game007.Util.Resources;
import com.ruslan23.game007.Util.Setting;
import com.ruslan23.game007.Interface.MyListener;
import com.ruslan23.module1.CoreOfGame.Core1;
import com.ruslan23.module1.CoreOfGame.Graphics1;

import java.util.ArrayList;

public class Loading extends AsyncTask<Void, Integer, Void> {
    private MyListener taskListener;
    private Core1 core1;

    public Loading(Core1 a, MyListener b) {
        taskListener = b;
        core1 = a;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Load_Of_Res.setProgressLoader(values[0]);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        loaderAssets();
        return null;
    }

    private void loadAudio(Core1 i) {
        Resources.soundTouch = i.getAudioFW().newSound("touching.ogg");
        Resources.hitSound = i.getAudioFW().newSound("allHits.ogg");
        Resources.musicOfGame = i.getAudioFW().newMusic("mainMusic.mp3");
        Resources.explode = i.getAudioFW().newSound("explodes.ogg");
    }

    private void loadSpritePlayer(Graphics1 i) {
        Resources.spriteOfExplosion = new ArrayList<>();
        Resources.spriteOfExplosion.add(i.newSprite(Resources.allTextures, 320, 256, 59, 61));
        Resources.spriteOfExplosion.add(i.newSprite(Resources.allTextures, 256, 256, 59, 61));
        Resources.spriteOfExplosion.add(i.newSprite(Resources.allTextures, 384, 256, 59, 61));
        Resources.spriteOfExplosion.add(i.newSprite(Resources.allTextures, 448, 256, 59, 61));
        Resources.spriteOfPlayer = new ArrayList<>();
        Resources.spriteOfPlayer.add(i.newSprite(Resources.allTextures, 64, 0, 64, 64));
        Resources.spriteOfPlayer.add(i.newSprite(Resources.allTextures, 0, 0, 64, 64));
        Resources.spriteOfPlayer.add(i.newSprite(Resources.allTextures, 192, 0, 64, 64));
        Resources.spriteOfPlayer.add(i.newSprite(Resources.allTextures, 128, 0, 64, 64));
        Resources.SpriteOfBoost = new ArrayList<>();
        Resources.SpriteOfBoost.add(i.newSprite(Resources.allTextures, 64, 64, 64, 64));
        Resources.SpriteOfBoost.add(i.newSprite(Resources.allTextures, 0, 64, 64, 64));
        Resources.SpriteOfBoost.add(i.newSprite(Resources.allTextures, 192, 64, 64, 64));
        Resources.SpriteOfBoost.add(i.newSprite(Resources.allTextures, 128, 64, 64, 64));
    }
    private void loaderAssets() {
        loadAllTextures(core1.getGraphicsFW());
        publishProgress(110);
        loadSpritePlayer(core1.getGraphicsFW());
        publishProgress(250);
        loadEnemy(core1.getGraphicsFW());
        publishProgress(470);
        loadMore(core1.getGraphicsFW());
        publishProgress(510);
        loadAudio(core1);
        loadPlayerWithShields(core1.getGraphicsFW());
        publishProgress(660);
        loadGift(core1.getGraphicsFW());
        publishProgress(780);
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        taskListener.onComplete();
    }
    private void loadGift(Graphics1 i) {
        Resources.protectorSprite = new ArrayList<>();
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,320, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,256, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,384, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,416, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,448, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,480, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,352, 192, 32, 32));
        Resources.protectorSprite.add(i.newSprite(Resources.allTextures,288, 192, 32, 32));
    }
    private void loadAllTextures(Graphics1 i) {
        Resources.textureOfSakura = i.newTexture("sakura.png");
        Resources.allTextures = i.newTexture("allTextures.png");
        Resources.sTextureCloud = i.newTexture("cloud.png");
        Resources.newYorkTexture = i.newTexture("new-york.jpg");
        Resources.bitcoin = i.newTexture("bitcoin.png");
        Resources.bitcoin1 = i.newTexture("bitcoin1.png");
        Resources.bitcoin2 = i.newTexture("bitcoin2.png");
    }
    private void loadPlayerWithShields(Graphics1 i) {
        Resources.spriteShieldsBoost = new ArrayList<>();
        Resources.spriteOfShieldsOn = new ArrayList<>();
        Resources.spriteShieldsBoost.add(i.newSprite(Resources.allTextures,64, 192, 64, 64));
        Resources.spriteShieldsBoost.add(i.newSprite(Resources.allTextures,0, 192, 64, 64));
        Resources.spriteShieldsBoost.add(i.newSprite(Resources.allTextures,192, 192, 64, 64));
        Resources.spriteShieldsBoost.add(i.newSprite(Resources.allTextures,128, 192, 64, 64));
        Resources.spriteOfShieldsOn.add(i.newSprite(Resources.allTextures,64, 128, 64, 64));
        Resources.spriteOfShieldsOn.add(i.newSprite(Resources.allTextures,0, 128, 64, 64));
        Resources.spriteOfShieldsOn.add(i.newSprite(Resources.allTextures,192, 128, 64, 64));
        Resources.spriteOfShieldsOn.add(i.newSprite(Resources.allTextures,128, 128, 64, 64));
    }
    private void loadMore(Graphics1 i) {
        Setting.load(core1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.mainMenuFont = core1.getResources().getFont(R.font.hanalei);
        } else {Resources.mainMenuFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.hanalei);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.settingsFont = core1.getResources().getFont(R.font.akronim);
        } else {Resources.settingsFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.akronim);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.exitFont = core1.getResources().getFont(R.font.allura);
        } else {Resources.exitFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.allura);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.resultsFont = core1.getResources().getFont(R.font.amita);
        } else {Resources.resultsFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.amita);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.pauseFont = core1.getResources().getFont(R.font.zilla_slab_highlight);
        } else {Resources.pauseFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.zilla_slab_highlight);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.readyFont = core1.getResources().getFont(R.font.sriracha);
        } else {Resources.readyFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.sriracha);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.gameOverFont = core1.getResources().getFont(R.font.vast_shadow);
        } else {Resources.gameOverFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.vast_shadow);}
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Resources.hudFont = core1.getResources().getFont(R.font.pattaya);
        } else {Resources.hudFont = ResourcesCompat.getFont(core1.getApplicationContext(),R.font.pattaya);}
        Resources.hitEnemy = i.newSprite(Resources.allTextures,384, 256, 64, 64);
    }

    private void loadEnemy(Graphics1 i) {
        Resources.enemySprite3 = new ArrayList<>();
        Resources.enemySprite3.add(i.newSprite(Resources.allTextures, 256, 128, 64, 64));
        Resources.enemySprite3.add(i.newSprite(Resources.allTextures, 320, 128, 64, 64));
        Resources.enemySprite3.add(i.newSprite(Resources.allTextures, 384, 128, 64, 64));
        Resources.enemySprite3.add(i.newSprite(Resources.allTextures, 448, 128, 64, 64));
        Resources.enemySprite = new ArrayList<>();
        Resources.enemySprite.add(i.newSprite(Resources.allTextures, 256, 0, 64, 64));
        Resources.enemySprite.add(i.newSprite(Resources.allTextures, 320, 0, 64, 64));
        Resources.enemySprite.add(i.newSprite(Resources.allTextures, 384, 0, 64, 64));
        Resources.enemySprite.add(i.newSprite(Resources.allTextures, 448, 0, 64, 64));
        Resources.enemySprite2 = new ArrayList<>();
        Resources.enemySprite2.add(i.newSprite(Resources.allTextures, 256, 64, 64, 64));
        Resources.enemySprite2.add(i.newSprite(Resources.allTextures, 320, 64, 64, 64));
        Resources.enemySprite2.add(i.newSprite(Resources.allTextures, 384, 64, 64, 64));
        Resources.enemySprite2.add(i.newSprite(Resources.allTextures, 448, 64, 64, 64));
    }
}