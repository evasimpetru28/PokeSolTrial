package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class CatalogueActivity extends AppCompatActivity {

    Button next;
    Button previous;
    Button goBackToCatalogue;
    Button goToCharacterSelect;
    ImageView bianca;
    ImageView carolina;
    ImageView dorin;
    ImageView lipan;
    ImageView lucian;
    ImageView popovici;
    ImageView srp;
    ImageView tana;
    static List<Integer> employeeIdList;

    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        goBackToCatalogue = findViewById(R.id.goBackButon);
        goToCharacterSelect = findViewById(R.id.backToCharacterSelect);

        bianca = findViewById(R.id.buton_bianca);
        carolina = findViewById(R.id.buton_carolina);
        dorin = findViewById(R.id.buton_dorin);
        lipan = findViewById(R.id.buton_lipan);
        lucian = findViewById(R.id.buton_lucian);
        popovici = findViewById(R.id.buton_popovici);
        srp = findViewById(R.id.buton_srp);
        tana = findViewById(R.id.buton_tana);

//        employeeIdList.add(R.id.buton_bianca);
//        employeeIdList.add(R.id.buton_carolina);
//        employeeIdList.add(R.id.buton_dorin);
//        employeeIdList.add(R.id.buton_lipan);
//        employeeIdList.add(R.id.buton_lucian);
//        employeeIdList.add(R.id.buton_popovici);
//        employeeIdList.add(R.id.buton_srp);
//        employeeIdList.add(R.id.buton_tana);

        lipan.setVisibility(View.GONE);
        lucian.setVisibility(View.GONE);
        popovici.setVisibility(View.GONE);
        srp.setVisibility(View.GONE);
        tana.setVisibility(View.GONE);

        next.setVisibility(View.VISIBLE);
        previous.setVisibility(View.GONE);
        goBackToCatalogue.setVisibility(View.GONE);

        bianca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carolina.setVisibility(View.GONE);
                dorin.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
            }
        });

        carolina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bianca.setVisibility(View.GONE);
                dorin.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
            }
        });

        dorin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carolina.setVisibility(View.GONE);
                bianca.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
            }
        });

        lipan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lucian.setVisibility(View.GONE);
                popovici.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                previous.setVisibility(View.GONE);
            }
        });

        lucian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lipan.setVisibility(View.GONE);
                popovici.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                previous.setVisibility(View.GONE);
            }
        });

        popovici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lipan.setVisibility(View.GONE);
                lucian.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                next.setVisibility(View.GONE);
                previous.setVisibility(View.GONE);
            }
        });

        srp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tana.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                previous.setVisibility(View.GONE);
            }
        });

        tana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srp.setVisibility(View.GONE);

                goBackToCatalogue.setVisibility(View.VISIBLE);
                goToCharacterSelect.setVisibility(View.GONE);
                previous.setVisibility(View.GONE);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage += 1;

                if (currentPage == 2) {
                    carolina.setVisibility(View.GONE);
                    dorin.setVisibility(View.GONE);
                    bianca.setVisibility(View.GONE);

                    lipan.setVisibility(View.VISIBLE);
                    lucian.setVisibility(View.VISIBLE);
                    popovici.setVisibility(View.VISIBLE);
                }
                else if (currentPage == 3) {
                    lipan.setVisibility(View.GONE);
                    lucian.setVisibility(View.GONE);
                    popovici.setVisibility(View.GONE);

                    srp.setVisibility(View.VISIBLE);
                    tana.setVisibility(View.VISIBLE);
                    next.setVisibility(View.GONE);
                }

                previous.setVisibility(View.VISIBLE);
            }

        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage -= 1;

                if (currentPage == 1) {
                    carolina.setVisibility(View.VISIBLE);
                    dorin.setVisibility(View.VISIBLE);
                    bianca.setVisibility(View.VISIBLE);

                    lipan.setVisibility(View.GONE);
                    lucian.setVisibility(View.GONE);
                    popovici.setVisibility(View.GONE);
                    previous.setVisibility(View.GONE);
                }
                else if (currentPage == 2) {
                    lipan.setVisibility(View.VISIBLE);
                    lucian.setVisibility(View.VISIBLE);
                    popovici.setVisibility(View.VISIBLE);

                    srp.setVisibility(View.GONE);
                    tana.setVisibility(View.GONE);
                }

                next.setVisibility(View.VISIBLE);
            }

        });

        goBackToCatalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCatalogue();
            }
        });

        goToCharacterSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToCharacterSelect();
            }
        });
    }

    private void goToCatalogue() {
        if (currentPage == 1) {
            bianca.setVisibility(View.VISIBLE);
            carolina.setVisibility(View.VISIBLE);
            dorin.setVisibility(View.VISIBLE);

            goBackToCatalogue.setVisibility(View.GONE);
            goToCharacterSelect.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }
        if (currentPage == 2) {
            lipan.setVisibility(View.VISIBLE);
            lucian.setVisibility(View.VISIBLE);
            popovici.setVisibility(View.VISIBLE);

            goBackToCatalogue.setVisibility(View.GONE);
            goToCharacterSelect.setVisibility(View.VISIBLE);

            next.setVisibility(View.VISIBLE);
            previous.setVisibility(View.VISIBLE);
        }
        if (currentPage == 3) {
            srp.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.VISIBLE);
            tana.setVisibility(View.VISIBLE);

            goBackToCatalogue.setVisibility(View.GONE);
            previous.setVisibility(View.VISIBLE);
        }
    }

    private void goBackToCharacterSelect() {
        startActivity(new Intent(this, CharacterSelectActivity.class));
    }
}