package com.example.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private boolean isPlaying = false;
    private int screenX;
    private int screenY;
    private Background background1;
    private Background background2;
    private ArrowUp arrowUp;
    private Paint paint;

    public GameView(Context context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());
        background2.x = screenX;

        arrowUp = new ArrowUp(screenX, screenY, getResources());

        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying) {

            update();
            draw();
            sleep();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            resume();
            return true;
        }else {
            pause();
        }
        return false;
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    private void update() {
        background1.x -= 10;
        background2.x -= 10;

        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX;
        }

    }

    private void  draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);

            Matrix matrix = new Matrix();
            matrix.setTranslate(500, 400);
            canvas.drawBitmap(arrowUp.arrow, matrix, paint);

            getHolder().unlockCanvasAndPost(canvas); // shows canvas on screen
        }
    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
