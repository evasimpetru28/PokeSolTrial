package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    Button actionMiron1, actionMiron2, actionMiron3, actionMiron4, fight_btn, run_btn;
    TextView main_q, final_msj;
    int random_run;
    ImageView main_miron, player_health, enemy_health, enemy_image;
    int diff, current_life_player, current_life_enemy;

    Enemy currentEnemy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        enemy_image = findViewById(R.id.enemy);
        enemy_image.setImageResource(GameActivity.enemyId);

        current_life_player = findViewById(R.id.player_life).getLayoutParams().width;
        current_life_enemy = findViewById(R.id.enemy_life).getLayoutParams().width;

        for (Enemy enemy : EnemyManagement.listOfEnemies) {
            if (enemy.pictureId.equals(GameActivity.enemyId)) {
                currentEnemy = enemy;
            }
        }

        main_q = findViewById(R.id.main_question);
        main_q.setText(R.string.will_you_fight);
        main_q.setVisibility(View.VISIBLE);
        fight_btn = findViewById(R.id.fight);
        run_btn = findViewById(R.id.run);


        actionMiron1 = findViewById(R.id.action1Miron);
        actionMiron2 = findViewById(R.id.action2Miron);
        actionMiron3 = findViewById(R.id.action3Miron);
        actionMiron4 = findViewById(R.id.action4Miron);
        actionMiron1.setVisibility(View.GONE);
        actionMiron2.setVisibility(View.GONE);
        actionMiron3.setVisibility(View.GONE);
        actionMiron4.setVisibility(View.GONE);

        main_miron = findViewById(R.id.player_miron);
        player_health = findViewById(R.id.player_life);
        enemy_health = findViewById(R.id.enemy_life);

        final_msj = findViewById(R.id.mesage);
        final_msj.setVisibility(View.GONE);

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

                    if (CharacterSelectActivity.avatar == R.drawable.miron) {

                        main_q.setText(R.string.miron_question);
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
                    main_q.setText(R.string.miron_question);

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

                main_q.setText(R.string.miron_uses_1);

                deleteEnemyHealthBar();


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (current_life_enemy != 0 && current_life_player != 0) {
                            main_q.setText(R.string.enemy_turn);
                        }

                    }
                }, 2000);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                            deleteHealthBar();
                            main_q.setText(currentEnemy.name + " used " + currentEnemy.enemyLines.get(new Random().nextInt(3)));
                        }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        main_q.setText(R.string.miron_question);
                    }
                }, 6000);

            }
        });

        actionMiron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);

                main_q.setText(R.string.miron_uses_2);

                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (current_life_enemy != 0 && current_life_player != 0) {
                            main_q.setText(R.string.enemy_turn);
                        }

                    }
                }, 2000);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                        deleteHealthBar();
                        main_q.setText(currentEnemy.name + " used " + currentEnemy.enemyLines.get(new Random().nextInt(3)));
                    }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        main_q.setText(R.string.miron_question);

                    }
                }, 6000);
            }
        });

        actionMiron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);

                main_q.setText(R.string.miron_uses_3);

                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (current_life_enemy != 0 && current_life_player != 0) {
                            main_q.setText(R.string.enemy_turn);
                        }

                    }
                }, 2000);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                        deleteHealthBar();
                        main_q.setText(currentEnemy.name + " used " + currentEnemy.enemyLines.get(new Random().nextInt(3)));
                    }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        main_q.setText(R.string.miron_question);
                    }
                }, 6000);
            }
        });

        actionMiron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);

                main_q.setText(R.string.miron_uses_4);

                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (current_life_enemy != 0 && current_life_player != 0) {
                            main_q.setText(R.string.enemy_turn);
                        }

                    }
                }, 2000);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                        deleteHealthBar();
                        main_q.setText(currentEnemy.name + " used " + currentEnemy.enemyLines.get(new Random().nextInt(3)));
                    }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        main_q.setText(R.string.miron_question);
                    }
                }, 6000);
            }
        });

    }

    private void goBackToGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void deleteHealthBar() {
        diff = (new Random().nextInt(4) + 1) * 100;

        current_life_player = findViewById(R.id.player_life).getLayoutParams().width;
        if (current_life_player > diff) {
            findViewById(R.id.player_life).getLayoutParams().width -= diff;
            current_life_player = findViewById(R.id.player_life).getLayoutParams().width;
        } else {
            current_life_player = 0;
        }

        if (current_life_player == 0) {
            main_q.setVisibility(View.GONE);
            player_health.setVisibility(View.GONE);
            enemy_health.setVisibility(View.GONE);
            final_msj.setText("You lost!");
            final_msj.setVisibility(View.VISIBLE);

            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                public void run() {
                    goBackToGame();
                }
            }, 1000);
        }
    }

    @SuppressLint("ResourceType")
    private void deleteEnemyHealthBar() {
        diff = (new Random().nextInt(4) + 1) * 100;

        current_life_enemy = findViewById(R.id.enemy_life).getLayoutParams().width;
        if (current_life_enemy > diff) {
            findViewById(R.id.enemy_life).getLayoutParams().width -= diff;
            current_life_enemy = findViewById(R.id.enemy_life).getLayoutParams().width;
        } else {
            current_life_enemy = 0;
        }

        if (current_life_enemy == 0) {
            currentEnemy.isDiscovered = true;
            main_q.setVisibility(View.GONE);
            enemy_health.setVisibility(View.GONE);
            player_health.setVisibility(View.GONE);
            final_msj.setText("You won!");
            final_msj.setVisibility(View.VISIBLE);

            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                public void run() {
                    goBackToGame();
                }
            }, 1000);
        }
    }

}