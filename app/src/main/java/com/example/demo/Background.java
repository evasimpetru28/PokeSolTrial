package com.example.demo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {
    int x = 0;
    int y = 0;
    Bitmap background;

    Background(int screenX, int screenY, Resources res, int id) {
        background = BitmapFactory.decodeResource(res, id);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }
}
