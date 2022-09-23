package com.example.demo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

//    float x;
//    float y;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        this.x = event.getX();
//        this.y = event.getY();
//
//        View playerView = findViewById(R.id.player);
//        View backView = findViewById(R.id.forest);
//        System.out.println(backView.getX());
//        float positionX = playerView.getX();
//        float positionY = playerView.getY();
//
//        if (y >= 310 && y <= 710 && x >= 1900) {
//            ObjectAnimator.ofFloat(playerView, "translationX", positionX, x - 100).setDuration(1000).start();
//            ObjectAnimator.ofFloat(playerView, "translationY", positionY, y - 300).setDuration(1000).start();
//            float backX = findViewById(R.id.forest).getX();
////            System.out.println("before " + backX);
//            ObjectAnimator.ofFloat(findViewById(R.id.forest), "translationX",  backX, -600).start();
////            System.out.println("after " + findViewById(R.id.forest).getX());
//        }
//
//        return true;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.AppName).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
//                findViewById(R.id.splashScreen).setLeft(-100);

                startActivity(new Intent(MainActivity.this, CharacterSelectActivity.class));
            }
        });
    }
}