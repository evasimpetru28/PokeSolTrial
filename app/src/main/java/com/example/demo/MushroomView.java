package com.example.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class MushroomView extends View {

    private Bitmap mushroom;

    private Paint paint = new Paint();

    public MushroomView(Context context) {
        super(context);
        mushroom = BitmapFactory.decodeResource(getResources(), R.drawable.mushroom);
        paint.setColor(Color.WHITE);
        paint.setTextSize(70);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mushroom, 0, 0, null);
        canvas.drawText("Padure", 50, 200, paint);
    }


}
