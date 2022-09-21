package com.example.demo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ArrowUp {

    int x = 0;
    int y = 0;
    Bitmap arrow;

    ArrowUp(int screenX, int screenY, Resources res, int id) {
        arrow = BitmapFactory.decodeResource(res, id);
        arrow = Bitmap.createScaledBitmap(arrow, 100, 400, false);
    }

}
