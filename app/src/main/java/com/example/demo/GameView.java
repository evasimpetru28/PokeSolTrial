package com.example.demo;

import static java.lang.Math.abs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Set;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    static boolean isPlaying = true;
    private final int screenX;
    private final int screenY;
    private Background background1;
    private Player player;
    private Paint paint;
    private Obstacle obstacle;
    private boolean k = false;
    private float x, y; // diferenta de nivel pe orizontala/verticala
    private float finalX, finalY;
    private int horizontal = 0, vertical = 0;//0 means nothing, 1 means right/down, -1 means left/up
    private boolean battle = false;
    private CustomButton backButton;
    private GameActivity gameActivity;
    private int randomX;
    private int randomY;

    public GameView(GameActivity gameActivity, int screenX, int screenY) {
        super(gameActivity);
        this.gameActivity = gameActivity;
        this.screenX = screenX;
        this.screenY = screenY;

        background1 = new Background(3000, 2000, getResources(), R.drawable.background);

        player = new Player(screenX, screenY, getResources(), CharacterSelectActivity.avatar);

        obstacle = new Obstacle(screenX, screenY, getResources());

        paint = new Paint();

        backButton = new CustomButton(screenX, screenY, getResources(), R.drawable.back_button);
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    private void goToCharacterSelect() {
        isPlaying = false;
        gameActivity.startActivity(new Intent(gameActivity, CharacterSelectActivity.class));
        gameActivity.finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            if(motionEvent.getY() <= 100 && motionEvent.getX() <= 120) {
                goToCharacterSelect();
            }
            else

            if (motionEvent.getX() < screenX - 200 && motionEvent.getY() < screenY - 150) {
                k = true;
                x = motionEvent.getX() - player.x;
                finalX = motionEvent.getX();
                if (x < 0) {
                    horizontal = -1;
                } else {
                    horizontal = 1;
                }

                y = motionEvent.getY() - player.y;
                finalY = motionEvent.getY();
                if (y < 0) {
                    vertical = -1;
                } else {
                    vertical = 1;
                }


            }
        }

        return true;
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
        if (k) {
            if (vertical == 1) {
                if (y > 0) {
                    player.y += 10;
                    if (player.y > screenY / 2) {
                        if ((abs(background1.y) + 1020 + 50) < 2000) {
                            background1.y -= 50;
                            obstacle.y -= 50;
                        } else {
                            background1.y -= (2000 - abs(background1.y) - 1020);
                        }
                    }
                    y -= 10;
                } else {
                    vertical = 0;
                    y = 0;
                }
            } else {
                if (y < 0) {
                    player.y -= 10;
                    if (player.y < screenY / 2 && background1.y != 0) {
                        if (background1.y <= -50) {
                            background1.y += 50;
                            obstacle.y += 50;
                        } else {
                            background1.y += abs(background1.y);
                        }
                    }
                    y += 10;
                } else {
                    vertical = 0;
                    y = 0;
                }
            }

            float proportion = 0;
            proportion = (abs(x) * 10) / abs(y);

            if (horizontal == 1) {
                if (x > 0) {
                    player.x += proportion;
                    if (player.x > 1500) {
                        battle = true;
                    }

                    if (player.x > screenX / 2) {
                        if ((abs(background1.x) + 2160 + 50) < 3000) {
                            background1.x -= 50;
                        } else {
                            background1.x -= (3000 - abs(background1.x) - 2160);
                        }
                    }
                    x -= proportion;
                } else {
                    horizontal = 0;
                    x = 0;
                }
            } else {
                if (x < 0) {
                    player.x -= proportion;
                    if (player.x < screenX / 2 && background1.x != 0) {
                        if (background1.x <= -50) {
                            background1.x += 10;
                        } else {
                            background1.x += abs(background1.x);
                        }
                    }
                    x += proportion;
                } else {
                    horizontal = 0;
                    x = 0;
                }
            }
        }
    }

    private void  draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            if (!battle) {
                canvas.drawBitmap(background1.background, background1.x, background1.y, paint);

                canvas.drawBitmap(player.player, player.x, player.y, paint);

                canvas.drawBitmap(obstacle.obstacle, obstacle.x, obstacle.y, paint);

                canvas.drawBitmap(backButton.button, backButton.x, backButton.y, paint);

            } else {
//                canvas.drawBitmap(background2.background, background2.x, background2.y, paint);
                battle = false;
            }

            getHolder().unlockCanvasAndPost(canvas);
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
