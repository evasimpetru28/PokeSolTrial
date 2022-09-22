package com.example.demo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Obstacle {
    int x = 680;
    int y = 200;
    Bitmap obstacle;

    Obstacle(int screenX, int screenY, Resources res) {
        obstacle = BitmapFactory.decodeResource(res, R.drawable.tree);
        obstacle = Bitmap.createScaledBitmap(obstacle, 800, 600, false);
    }
}
