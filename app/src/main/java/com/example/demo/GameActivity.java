package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private float touchEventX, touchEventY;
    private boolean flag = false;
    private int touches = 0;
    private int randomTouches = 0;
    private boolean k = true;
    private float posX = 0, posY = 0;
    static int enemyId;
    private List<Integer> listOfCharacters = new ArrayList<>(Arrays.asList(R.drawable.bianca, R.drawable.carolina, R.drawable.dorin,
            R.drawable.lipan, R.drawable.lucian, R.drawable.tana, R.drawable.srp, R.drawable.popovici));

    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        System.out.println("s a intrattttttttttttttttttttttt");

        if (touches == randomTouches) {
            int rand = (new Random()).nextInt((7 - 0 + 1) + 1);
            enemyId = listOfCharacters.get(rand);
            startActivity(new Intent(this, CharacterSelectActivity.class));
        }

        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                touches++;
                System.out.println(touches);
                break;
            default:
                return super.onTouchEvent(event);
        }

        flag = false;

        this.touchEventX = event.getX();
        this.touchEventY = event.getY();

        View player = findViewById(R.id.player);

        float positionX = player.getX();
        float positionY = player.getY();

        if (touchEventX > player.getX()) {
            ((ImageView) player).setScaleX(1);
        } else {
            ((ImageView) player).setScaleX(-1);
        }

        if (posY == 0 && posX == 0) {

            if (touchEventY > 667){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 315).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == 0 && posX == -770) {

            if (touchEventY > 667){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == 0 && posX == -1540) {

            if (touchEventY > 667){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY > 321){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == 0 && posX == -2310) {

            if (touchEventY > 667){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY > 321){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == -600 && posX == 0) {

            if (touchEventY > 970){
                touches++;
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        player.setZ(3);
                    }
                }, 1000);
            } else {
                touches++;
                player.setZ(1);
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }

            if (touchEventY >= 315) {
                touches++;
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                touches++;
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == -600 && posX == -770) {

            if (touchEventY > 970){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == -600 && posX == -1540) {

            if (touchEventY > 970){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        if (posY == -600 && posX == -2310) {

            if (touchEventY > 970){
                player.setZ(3);
            } else {
                player.setZ(1);
            }

            if (touchEventY >= 315) {
                ObjectAnimator.ofFloat(player, "translationY", positionY, touchEventY - 300).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            } else {
                ObjectAnimator.ofFloat(player, "translationY", positionY, 25).setDuration(1500).start();
                ObjectAnimator.ofFloat(player, "translationX", positionX, touchEventX - 100).setDuration(1500).start();
            }
        }

        return true;
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        System.out.println("aaaaa"  + savedInstanceState.get("x"));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putFloat("x", findViewById(R.id.player).getX());
        outState.putFloat("y", findViewById(R.id.player).getY());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        randomTouches = (new Random()).nextInt((15 + 0) + 1) + 0;
        System.out.println(randomTouches);

        setContentView(R.layout.activity_game);

        View playerView = findViewById(R.id.player);
        ((ImageView) playerView).setImageResource(CharacterSelectActivity.avatar);

        playerView.setZ(1);
        playerView.setY(590);
        playerView.setX(-300);

        ObjectAnimator.ofFloat(playerView, "translationX", -300, 0).setDuration(2000).start();

        playerView.setX(300);

        View emptyRight = findViewById(R.id.emptyMarginRight);
        emptyRight.setAlpha(0);
        View emptyLeft = findViewById(R.id.emptyMarginLeft);
        emptyLeft.setAlpha(0);
        View empty = findViewById(R.id.empty);
        empty.setAlpha(0);
        View backgroundView = findViewById(R.id.background);
        View houseView = findViewById(R.id.house);
        View tallTree1 = findViewById(R.id.tallTree1);
        tallTree1.setZ(5);
        View tallTree2 = findViewById(R.id.tallTree2);
        tallTree2.setZ(5);
        View tallTree3 = findViewById(R.id.tallTree3);
        tallTree3.setZ(2);
        View tallTree4 = findViewById(R.id.tallTree4);
        tallTree4.setZ(2);
        View fatTree1 = findViewById(R.id.fatTree1);
        fatTree1.setZ(2);
        View fatTree2 = findViewById(R.id.fatTree2);
        fatTree2.setZ(4);
        View shed = findViewById(R.id.shed);
        View stables = findViewById(R.id.stables);
        stables.setZ(5);
        View leftBench = findViewById(R.id.leftBanca);
        Button prevButton = findViewById(R.id.buttonBack);
        View rightBench = findViewById(R.id.rightBanca);
        rightBench.bringToFront();
        View bush1 = findViewById(R.id.bush1);
        View bush2 = findViewById(R.id.bush2);
        View bush3 = findViewById(R.id.bush3);

        prevButton.setOnClickListener(view -> {
            startActivity(new Intent(this, CharacterSelectActivity.class));
        });


        findViewById(R.id.buttonUp).setVisibility(View.INVISIBLE);
        findViewById(R.id.buttonLeft).setVisibility(View.INVISIBLE);

        houseView.setOnClickListener(view -> {
        });

        shed.setOnClickListener(view -> {
        });


        tallTree3.setOnClickListener(view -> {
        });

        tallTree4.setOnClickListener(view -> {
        });

        stables.setOnClickListener(view -> {
        });

        empty.setOnClickListener(view -> {
        });

        emptyLeft.setOnClickListener(view -> {
        });

        emptyRight.setOnClickListener(view -> {
        });

        leftBench.setOnClickListener(view -> {
        });

        rightBench.setOnClickListener(view -> {
        });

        bush1.setOnClickListener(view -> {
        });

        bush2.setOnClickListener(view -> {
        });

        bush3.setOnClickListener(view -> {
        });

        findViewById(R.id.buttonUp).setOnClickListener(view -> {
            if (posY != 0) {
                ObjectAnimator.ofFloat(backgroundView, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(houseView, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree1, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree1, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree2, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree2, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(playerView, "translationY", playerView.getY(), playerView.getY() + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(shed, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree3, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree4, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(stables, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(leftBench, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(rightBench, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush1, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush2, "translationY", posY, posY + 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush3, "translationY", posY, posY + 600).setDuration(1000).start();

                posY += 600;

                findViewById(R.id.buttonUp).setVisibility(View.INVISIBLE);
                findViewById(R.id.buttonDown).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.buttonDown).setOnClickListener(view -> {
            if (posY != -600) {
                ObjectAnimator.ofFloat(backgroundView, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(houseView, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree1, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree1, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree2, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree2, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(playerView, "translationY", playerView.getY(), playerView.getY() - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(shed, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree3, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree4, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(stables, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(leftBench, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(rightBench, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush1, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush2, "translationY", posY, posY - 600).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush3, "translationY", posY, posY - 600).setDuration(1000).start();

                posY -= 600;

                findViewById(R.id.buttonUp).setVisibility(View.VISIBLE);
                findViewById(R.id.buttonDown).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.buttonLeft).setOnClickListener(view -> {
            if (posX != 0) {
                ObjectAnimator.ofFloat(backgroundView, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(houseView, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree1, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree1, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree2, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree2, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(playerView, "translationX", playerView.getX(), playerView.getX() + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(shed, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree3, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree4, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(stables, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(emptyRight, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(emptyLeft, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(leftBench, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(rightBench, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush1, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush2, "translationX", posX, posX + 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush3, "translationX", posX, posX + 770).setDuration(1000).start();

                posX += 770;

                if (posX == 0) {
                    findViewById(R.id.buttonLeft).setVisibility(View.INVISIBLE);
                }

                findViewById(R.id.buttonRight).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.buttonRight).setOnClickListener(view -> {
            if (posX != -2310) {
                ObjectAnimator.ofFloat(backgroundView, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(houseView, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree1, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree1, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree2, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(fatTree2, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(playerView, "translationX", playerView.getX(), playerView.getX() - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(shed, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree3, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(tallTree4, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(stables, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(emptyRight, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(emptyLeft, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(leftBench, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(rightBench, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush1, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush2, "translationX", posX, posX - 770).setDuration(1000).start();
                ObjectAnimator.ofFloat(bush3, "translationX", posX, posX - 770).setDuration(1000).start();

                posX -= 770;

                if (posX == -2310) {
                    findViewById(R.id.buttonRight).setVisibility(View.INVISIBLE);
                }

                findViewById(R.id.buttonLeft).setVisibility(View.VISIBLE);
            }
        });
    }
}