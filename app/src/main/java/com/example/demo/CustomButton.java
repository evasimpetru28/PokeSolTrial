package com.example.demo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CustomButton {

    int x = 20;
    int y = 50;
    Bitmap button;

    CustomButton(int screenX, int screenY, Resources res, int id) {
        button = BitmapFactory.decodeResource(res, id);
        button = Bitmap.createScaledBitmap(button, 100, 50, false);
    }
}
