package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CharacterSelectActivity extends AppCompatActivity {

    Button switchToSecondActivity;
    Button goBack;
    ImageView selectMiron;
    ImageView selectMos;
    ImageView selectVang;
    static int avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch_select);


        selectMiron = findViewById(R.id.buton_miron);
        selectMiron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMiron.setImageDrawable(getResources().getDrawable(R.drawable.forest));

                avatar = R.drawable.miron;

                selectVang.setVisibility(View.GONE);
                selectMos.setVisibility(View.GONE);
                goBack.setVisibility(View.VISIBLE);
            }
        });

        selectMos = findViewById(R.id.buton_mos);
        selectMos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectMos.setImageDrawable(getResources().getDrawable(R.drawable.mushroom));

                avatar = R.drawable.mos;

                selectMiron.setVisibility(View.GONE);
                selectVang.setVisibility(View.GONE);
                goBack.setVisibility(View.VISIBLE);
            }
        });

        selectVang = findViewById(R.id.buton_vang);
        selectVang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectVang.setImageDrawable(getResources().getDrawable(R.drawable.arrow_up));

                avatar = R.drawable.vang;

                selectMos.setVisibility(View.GONE);
                selectMiron.setVisibility(View.GONE);
                goBack.setVisibility(View.VISIBLE);
            }
        });

        goBack = findViewById(R.id.goBackButon);
        goBack.setVisibility(View.GONE);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectVang.setImageDrawable(getResources().getDrawable(R.drawable.vang));
                selectMos.setImageDrawable(getResources().getDrawable(R.drawable.mos));
                selectMiron.setImageDrawable(getResources().getDrawable(R.drawable.miron));

                selectMiron.setVisibility(View.VISIBLE);
                selectMos.setVisibility(View.VISIBLE);
                selectVang.setVisibility(View.VISIBLE);
                goBack.setVisibility(View.GONE);
            }
        });

        switchToSecondActivity = findViewById(R.id.activity_first_button); // id pe ultimul buton din character select menu
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, GameActivity.class);
        startActivity(switchActivityIntent);
    }

}