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
    Button seeCatalogue;
    ImageView selectMiron;
    ImageView selectMos;
    ImageView selectVang;
    static int avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch_select);

        seeCatalogue = findViewById(R.id.catalogue);
        seeCatalogue.setVisibility(View.VISIBLE);

        selectMiron = findViewById(R.id.buton_miron);
        selectMiron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToSecondActivity.setVisibility(View.VISIBLE);
                avatar = R.drawable.miron;

                selectVang.setVisibility(View.GONE);
                selectMos.setVisibility(View.GONE);
                goBack.setVisibility(View.VISIBLE);
                seeCatalogue.setVisibility(View.GONE);
            }
        });

        selectMos = findViewById(R.id.buton_mos);
        selectMos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToSecondActivity.setVisibility(View.VISIBLE);
                avatar = R.drawable.mos;

                selectMiron.setVisibility(View.GONE);
                selectVang.setVisibility(View.GONE);
                goBack.setVisibility(View.VISIBLE);
                seeCatalogue.setVisibility(View.GONE);
            }
        });

        selectVang = findViewById(R.id.buton_vang);
        selectVang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToSecondActivity.setVisibility(View.VISIBLE);
                avatar = R.drawable.vang;

                selectMos.setVisibility(View.GONE);
                selectMiron.setVisibility(View.GONE);
                goBack.setVisibility(View.VISIBLE);
                seeCatalogue.setVisibility(View.GONE);
            }
        });

        goBack = findViewById(R.id.goBackButon);
        goBack.setVisibility(View.GONE);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToSecondActivity.setVisibility(View.GONE);

                selectMiron.setVisibility(View.VISIBLE);
                selectMos.setVisibility(View.VISIBLE);
                selectVang.setVisibility(View.VISIBLE);
                goBack.setVisibility(View.GONE);
                seeCatalogue.setVisibility(View.VISIBLE);
            }
        });

        seeCatalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToCatalogue();
            }
        });


        switchToSecondActivity = findViewById(R.id.activity_first_button); // id pe ultimul buton din character select menu
        switchToSecondActivity.setVisibility(View.GONE);
        switchToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchToCatalogue() {
        startActivity(new Intent(this, CatalogueActivity.class));
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, BattleActivity.class); // trebuie schimbat cu game activity
        startActivity(switchActivityIntent);
    }

}