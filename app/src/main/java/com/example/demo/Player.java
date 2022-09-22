package com.example.demo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import androidx.fragment.app.Fragment;

public class Player {

    int x = 1080;
    int y = 510;
    Bitmap player;

    Player(int screenX, int screenY, Resources res, int avatar) {
        player = BitmapFactory.decodeResource(res, avatar);
        player = Bitmap.createScaledBitmap(player, 290, 180, false);
    }
}
