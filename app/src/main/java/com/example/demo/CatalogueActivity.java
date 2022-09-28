package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class CatalogueActivity extends AppCompatActivity {

    Button next, previous, goBackToCatalogue, goToCharacterSelect;
    ImageView bianca, carolina, dorin, lipan, lucian, popovici, srp, tana, last;
    float lastDiff;
    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        for (Enemy enemy : EnemyManagement.listOfEnemies) {
            if (enemy.pictureId.equals(R.drawable.bianca) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_bianca_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.carolina) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_carolina_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.dorin) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_dorin_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.lipan) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_lipan_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.lucian) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_lucian_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.popovici) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_popovici_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.tana) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_tana_hidden).setVisibility(View.GONE);
            } else if (enemy.pictureId.equals(R.drawable.srp) && enemy.isDiscovered == true) {
                findViewById(R.id.buton_srp_hidden).setVisibility(View.GONE);
            }
        }

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

        lipan.setVisibility(View.GONE);
        findViewById(R.id.buton_lipan_hidden).setVisibility(View.GONE);
        lucian.setVisibility(View.GONE);
        findViewById(R.id.buton_lucian_hidden).setVisibility(View.GONE);
        popovici.setVisibility(View.GONE);
        findViewById(R.id.buton_popovici_hidden).setVisibility(View.GONE);
        srp.setVisibility(View.GONE);
        findViewById(R.id.buton_srp_hidden).setVisibility(View.GONE);
        tana.setVisibility(View.GONE);
        findViewById(R.id.buton_tana_hidden).setVisibility(View.GONE);

        next.setVisibility(View.VISIBLE);
        previous.setVisibility(View.GONE);
        goBackToCatalogue.setVisibility(View.GONE);

        bianca.setOnClickListener(view -> {
            carolina.setVisibility(View.GONE);
            findViewById(R.id.buton_bianca_hidden).setVisibility(View.GONE);
            dorin.setVisibility(View.GONE);
            findViewById(R.id.buton_dorin_hidden).setVisibility(View.GONE);

            last = null;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
        });

        carolina.setOnClickListener(view -> {
            bianca.setVisibility(View.GONE);
            findViewById(R.id.buton_bianca_hidden).setVisibility(View.GONE);
            dorin.setVisibility(View.GONE);
            findViewById(R.id.buton_dorin_hidden).setVisibility(View.GONE);

            carolina.setX(carolina.getX() - 700);
            lastDiff = 700;
            last = carolina;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
        });

        dorin.setOnClickListener(view -> {
            carolina.setVisibility(View.GONE);
            findViewById(R.id.buton_carolina_hidden).setVisibility(View.GONE);
            bianca.setVisibility(View.GONE);
            findViewById(R.id.buton_bianca_hidden).setVisibility(View.GONE);

            dorin.setX(dorin.getX() - 1420);
            lastDiff = 1420;
            last = dorin;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
        });

        lipan.setOnClickListener(view -> {
            lucian.setVisibility(View.GONE);
            popovici.setVisibility(View.GONE);

            last = null;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
        });

        lucian.setOnClickListener(view -> {
            lipan.setVisibility(View.GONE);
            popovici.setVisibility(View.GONE);

            lucian.setX(lucian.getX() - 700);
            lastDiff = 700;
            last = lucian;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
        });

        popovici.setOnClickListener(view -> {
            lipan.setVisibility(View.GONE);
            lucian.setVisibility(View.GONE);

            popovici.setX(popovici.getX() - 1420);
            lastDiff = 1420;
            last = popovici;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            previous.setVisibility(View.GONE);
        });

        srp.setOnClickListener(view -> {
            tana.setVisibility(View.GONE);

            last = null;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            previous.setVisibility(View.GONE);
        });

        tana.setOnClickListener(view -> {
            srp.setVisibility(View.GONE);
            findViewById(R.id.buton_srp_hidden).setVisibility(View.GONE);

            tana.setX(tana.getX() - 700);
            lastDiff = 700;
            last = tana;

            goBackToCatalogue.setVisibility(View.VISIBLE);
            goToCharacterSelect.setVisibility(View.GONE);
            previous.setVisibility(View.GONE);
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage += 1;

                if (currentPage == 2) {
                    next.setVisibility(View.VISIBLE);
                    carolina.setVisibility(View.GONE);
                    findViewById(R.id.buton_carolina_hidden).setVisibility(View.GONE);

                    dorin.setVisibility(View.GONE);
                    findViewById(R.id.buton_dorin_hidden).setVisibility(View.GONE);
                    bianca.setVisibility(View.GONE);
                    findViewById(R.id.buton_bianca_hidden).setVisibility(View.GONE);

                    lipan.setVisibility(View.VISIBLE);
                    lucian.setVisibility(View.VISIBLE);
                    popovici.setVisibility(View.VISIBLE);

                    for (Enemy enemy : EnemyManagement.listOfEnemies) {
                        if (enemy.pictureId.equals(R.drawable.lipan) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_lipan_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.lucian) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_lucian_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.popovici) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_popovici_hidden).setVisibility(View.VISIBLE);
                        }
                    }
                }
                else if (currentPage == 3) {
                    next.setVisibility(View.GONE);
                    lipan.setVisibility(View.GONE);
                    findViewById(R.id.buton_lipan_hidden).setVisibility(View.GONE);
                    lucian.setVisibility(View.GONE);
                    findViewById(R.id.buton_lucian_hidden).setVisibility(View.GONE);
                    popovici.setVisibility(View.GONE);
                    findViewById(R.id.buton_popovici_hidden).setVisibility(View.GONE);


                    srp.setVisibility(View.VISIBLE);
                    tana.setVisibility(View.VISIBLE);
                    for (Enemy enemy : EnemyManagement.listOfEnemies) {
                        if (enemy.pictureId.equals(R.drawable.srp) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_srp_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.tana) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_tana_hidden).setVisibility(View.VISIBLE);
                        }
                    }
                }

                previous.setVisibility(View.VISIBLE);
            }

        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage -= 1;

                if (currentPage == 1) {
                    for (Enemy enemy : EnemyManagement.listOfEnemies) {
                        if (enemy.pictureId.equals(R.drawable.carolina) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_carolina_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.bianca) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_bianca_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.dorin) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_dorin_hidden).setVisibility(View.VISIBLE);
                        }
                    }
                    carolina.setVisibility(View.VISIBLE);
                    dorin.setVisibility(View.VISIBLE);
                    bianca.setVisibility(View.VISIBLE);

                    lipan.setVisibility(View.GONE);
                    findViewById(R.id.buton_lipan_hidden).setVisibility(View.GONE);
                    lucian.setVisibility(View.GONE);
                    findViewById(R.id.buton_lucian_hidden).setVisibility(View.GONE);
                    popovici.setVisibility(View.GONE);
                    findViewById(R.id.buton_popovici_hidden).setVisibility(View.GONE);
                    previous.setVisibility(View.GONE);
                }
                else if (currentPage == 2) {
                    for (Enemy enemy : EnemyManagement.listOfEnemies) {
                        if (enemy.pictureId.equals(R.drawable.lipan) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_lipan_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.lucian) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_lucian_hidden).setVisibility(View.VISIBLE);
                        }

                        if (enemy.pictureId.equals(R.drawable.popovici) && enemy.isDiscovered == false) {
                            findViewById(R.id.buton_popovici_hidden).setVisibility(View.VISIBLE);
                        }
                    }
                    lipan.setVisibility(View.VISIBLE);
                    lucian.setVisibility(View.VISIBLE);
                    popovici.setVisibility(View.VISIBLE);

                    srp.setVisibility(View.GONE);
                    findViewById(R.id.buton_srp_hidden).setVisibility(View.GONE);
                    tana.setVisibility(View.GONE);
                    findViewById(R.id.buton_tana_hidden).setVisibility(View.GONE);
                }

                next.setVisibility(View.VISIBLE);
            }

        });

        goBackToCatalogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (last != null) {
                    last.setX(last.getX() + lastDiff);
                }

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
            for (Enemy enemy : EnemyManagement.listOfEnemies) {
                if (enemy.pictureId.equals(R.drawable.bianca) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_bianca_hidden).setVisibility(View.VISIBLE);
                }

                if (enemy.pictureId.equals(R.drawable.carolina) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_carolina_hidden).setVisibility(View.VISIBLE);
                }

                if (enemy.pictureId.equals(R.drawable.dorin) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_dorin_hidden).setVisibility(View.VISIBLE);
                }
            }
            bianca.setVisibility(View.VISIBLE);
            carolina.setVisibility(View.VISIBLE);
            dorin.setVisibility(View.VISIBLE);

            goBackToCatalogue.setVisibility(View.GONE);
            goToCharacterSelect.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        }
        if (currentPage == 2) {
            for (Enemy enemy : EnemyManagement.listOfEnemies) {
                if (enemy.pictureId.equals(R.drawable.lipan) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_lipan_hidden).setVisibility(View.VISIBLE);
                }

                if (enemy.pictureId.equals(R.drawable.lucian) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_lucian_hidden).setVisibility(View.VISIBLE);
                }

                if (enemy.pictureId.equals(R.drawable.popovici) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_popovici_hidden).setVisibility(View.VISIBLE);
                }
            }
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
            tana.setVisibility(View.VISIBLE);
            for (Enemy enemy : EnemyManagement.listOfEnemies) {
                if (enemy.pictureId.equals(R.drawable.srp) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_srp_hidden).setVisibility(View.VISIBLE);
                }

                if (enemy.pictureId.equals(R.drawable.tana) && enemy.isDiscovered == false) {
                    findViewById(R.id.buton_tana_hidden).setVisibility(View.VISIBLE);
                }
            }

            goToCharacterSelect.setVisibility(View.VISIBLE);
            goBackToCatalogue.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            previous.setVisibility(View.VISIBLE);
        }
    }

    private void goBackToCharacterSelect() {
        startActivity(new Intent(this, CharacterSelectActivity.class));
    }
}