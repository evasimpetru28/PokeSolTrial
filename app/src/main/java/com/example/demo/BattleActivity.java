package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    Button actionMiron1;
    Button actionMiron2;
    Button actionMiron3;
    Button actionMiron4;
    Button actionVang1;
    Button actionVang2;
    Button actionVang3;
    Button actionVang4;
    Button actionMos1;
    Button actionMos2;
    Button actionMos3;
    Button actionMos4;
    TextView vang_question;
    TextView mos_question;
    TextView miron_q;
    TextView main_q;
    Button fight_btn;
    Button run_btn;
    int random_run;
    ImageView main_miron;

    TextView miron_act1_used;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        main_q = findViewById(R.id.main_question);
        main_q.setVisibility(View.VISIBLE);
        fight_btn = findViewById(R.id.fight);
        run_btn = findViewById(R.id.run);

        miron_q =findViewById(R.id.miron_question);
        miron_q.setVisibility(View.GONE);
        actionMiron1 = findViewById(R.id.action1Miron);
        actionMiron2 = findViewById(R.id.action2Miron);
        actionMiron3 = findViewById(R.id.action3Miron);
        actionMiron4 = findViewById(R.id.action4Miron);
        actionMiron1.setVisibility(View.GONE);
        actionMiron2.setVisibility(View.GONE);
        actionMiron3.setVisibility(View.GONE);
        actionMiron4.setVisibility(View.GONE);

        miron_act1_used = findViewById(R.id.miron_used1);
        miron_act1_used.setVisibility(View.GONE);

        main_miron = findViewById(R.id.player_miron);

        if (CharacterSelectActivity.avatar == R.drawable.miron) {
            main_miron.setVisibility(View.VISIBLE);
        }

        run_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random_run = new Random().nextInt(2);
                if (random_run == 1) {
                    goBackToGame();
                }
                else {
                    fight_btn.setVisibility(View.GONE);
                    run_btn.setVisibility(View.GONE);
                    main_q.setVisibility(View.GONE);

                    if (CharacterSelectActivity.avatar == R.drawable.miron) {

                        miron_q.setVisibility(View.VISIBLE);
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                    }

                }
            }
        });

        fight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CharacterSelectActivity.avatar == R.drawable.miron) {
                    fight_btn.setVisibility(View.GONE);
                    run_btn.setVisibility(View.GONE);
                    main_q.setVisibility(View.GONE);

                    miron_q.setVisibility(View.VISIBLE);
                    actionMiron1.setVisibility(View.VISIBLE);
                    actionMiron2.setVisibility(View.VISIBLE);
                    actionMiron3.setVisibility(View.VISIBLE);
                    actionMiron4.setVisibility(View.VISIBLE);
                }

            }
        });

        actionMiron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
                miron_q.setVisibility(View.GONE);
                miron_act1_used.setVisibility(View.VISIBLE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                    }
                }, 1000);

            }
        });

        actionMiron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
            }
        });

        actionMiron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
            }
        });

        actionMiron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
            }
        });

    }

    private void goBackToGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }


}