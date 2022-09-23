package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    TextView miron_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        actionMiron1 = findViewById(R.id.action1Miron);
        actionMiron2 = findViewById(R.id.action2Miron);
        actionMiron3 = findViewById(R.id.action3Miron);
        actionMiron4 = findViewById(R.id.action4Miron);

//        actionMos1 = findViewById(R.id.action1Mos);
//        actionMos2 = findViewById(R.id.action2Mos);
//        actionMos3 = findViewById(R.id.action3Mos);
//        actionMos4 = findViewById(R.id.action4Mos);
//
//        actionVang1 = findViewById(R.id.action1Vang);
//        actionVang2 = findViewById(R.id.action2Vang);
//        actionVang3 = findViewById(R.id.action3Vang);
//        actionVang4 = findViewById(R.id.action4Vang);
//
        mos_question = findViewById(R.id.mos_question);
        vang_question = findViewById(R.id.vang_question);
        miron_question = findViewById(R.id.miron_question);

        if (CharacterSelectActivity.avatar == R.id.buton_vang) {
            actionMos1.setVisibility(View.GONE);
            actionMos2.setVisibility(View.GONE);
            actionMos3.setVisibility(View.GONE);
            actionMos4.setVisibility(View.GONE);
            actionMiron1.setVisibility(View.GONE);
            actionMiron2.setVisibility(View.GONE);
            actionMiron3.setVisibility(View.GONE);
            actionMiron4.setVisibility(View.GONE);

            miron_question.setVisibility(View.GONE);
//            mos_question.setVisibility(View.GONE);

            actionVang1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.vang_question, 1);
                }
            });
            actionVang2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.vang_question, 2);
                }
            });

            actionVang3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.vang_question, 3);
                }
            });

            actionVang4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.vang_question, 4);
                }
            });

        }
        if (CharacterSelectActivity.avatar == R.id.buton_miron) {
            actionMos1.setVisibility(View.GONE);
            actionMos2.setVisibility(View.GONE);
            actionMos3.setVisibility(View.GONE);
            actionMos4.setVisibility(View.GONE);
            actionVang1.setVisibility(View.GONE);
            actionVang2.setVisibility(View.GONE);
            actionVang3.setVisibility(View.GONE);
            actionVang4.setVisibility(View.GONE);

            mos_question.setVisibility(View.GONE);
            vang_question.setVisibility(View.GONE);

            actionMiron1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.miron_question, 1);
                }
            });

            actionMiron2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.miron_question, 2);
                }
            });

            actionMiron3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.miron_question, 3);
                }
            });

            actionMiron4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.miron_question, 4);
                }
            });
        }
        if (CharacterSelectActivity.avatar == R.id.buton_mos) {
            actionVang1.setVisibility(View.GONE);
            actionVang2.setVisibility(View.GONE);
            actionVang3.setVisibility(View.GONE);
            actionVang4.setVisibility(View.GONE);
            actionMiron1.setVisibility(View.GONE);
            actionMiron2.setVisibility(View.GONE);
            actionMiron3.setVisibility(View.GONE);
            actionMiron4.setVisibility(View.GONE);

            vang_question.setVisibility(View.GONE);
            miron_question.setVisibility(View.GONE);

            actionMos1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.mos_question, 1);
                }
            });
            actionMos2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.mos_question, 2);
                }
            });

            actionMos3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.mos_question, 3);
                }
            });

            actionMos4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doAction(R.id.mos_question, 4);
                }
            });
        }

    }

    private void doAction(int avatar, int nr) {

    }

}