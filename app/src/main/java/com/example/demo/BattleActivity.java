package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
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
    TextView final_msj;
    boolean invalidateGame = false;

    int enemy = GameActivity.enemyId;
//    int enemy = R.drawable.carolina;

    TextView miron_act1_used;
    TextView miron_act2_used;
    TextView miron_act3_used;
    TextView miron_act4_used;

    TextView enemy_line_show;


    ImageView player_health;
    ImageView enemy_health;
    ImageView enemy_image;

    int diff;
    int curret_life_player;
    int curret_life_enemy;
    String name;

    List<String> enemyLines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        enemy_image = findViewById(R.id.enemy);
        enemy_image.setImageResource(enemy);

        enemy_line_show = (TextView) findViewById(R.id.enemy_action);
        enemy_line_show.setVisibility(View.GONE);

        if (enemy == R.drawable.bianca) {
            name= "Bianca";
            enemyLines.add("Ce faceti dragilooor?");
            enemyLines.add(":)");
            enemyLines.add("Meeting scurt de aliniere");
            enemyLines.add("Imbratiseaza schimbarea");

        }

        if (enemy == R.drawable.carolina) {
            name = "Carolina";
            enemyLines.add("Facem sa mearga?");
            enemyLines.add("Nu mancam si noi ceva bun?");
            enemyLines.add("HR goes brrr");
            enemyLines.add("Prajituri la bucatarie!");
        }

        if (enemy == R.drawable.dorin) {
            name = "Dorin";
            enemyLines.add("Punem un task");
            enemyLines.add("Div-ul e cu 3 px prea pe stanga");
            enemyLines.add("The cake is a lie");
            enemyLines.add("NU ara ca-n design");
        }

        if (enemy == R.drawable.lipan) {
            name = "Lipan";
            enemyLines.add("Ce faceti chiftelute?");
            enemyLines.add("Ce e basina asta?");
            enemyLines.add("Pe scurt ca am treaba");
            enemyLines.add("Ce sparti sunteti");
        }

        if (enemy == R.drawable.lucian) {
            name = "Lucian";
            enemyLines.add("Aveti 5 min sa vb despre Spark?");
            enemyLines.add("Log this");
            enemyLines.add("Stii, Cassandra:");
            enemyLines.add("Dar Kafka:");
        }

        if (enemy == R.drawable.popovici) {
            name = "Popovici";
            enemyLines.add("Avem contract?");
            enemyLines.add("E bine de tot");
            enemyLines.add("Sunt distrus!");
            enemyLines.add("Mamaa maaama");
        }

        if (enemy == R.drawable.srp) {
            name = "SRP";
            enemyLines.add("Da-i din linia de comanda");
            enemyLines.add("Golan(g)");
            enemyLines.add("Sah mat si poarta-n casa");
            enemyLines.add("F***m tot!");
        }

        if (enemy == R.drawable.tana) {
            name = "Tana";
            enemyLines.add("Hai ca daca asa e, asa facem");
            enemyLines.add("Seeeexy");
            enemyLines.add("Lasa ba ca merge si-asa");
            enemyLines.add("Vara ispitelor");
        }

        enemy_line_show.setText(name + " used " + enemyLines.get(new Random().nextInt(3)));

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

        miron_act2_used = findViewById(R.id.miron_used2);
        miron_act2_used.setVisibility(View.GONE);

        miron_act3_used = findViewById(R.id.miron_used3);
        miron_act3_used.setVisibility(View.GONE);

        miron_act4_used = findViewById(R.id.miron_used4);
        miron_act4_used.setVisibility(View.GONE);


        main_miron = findViewById(R.id.player_miron);
        player_health = findViewById(R.id.player_life);
        enemy_health = findViewById(R.id.enemy_life);
        final_msj = findViewById(R.id.mesage);

        final_msj.setVisibility(View.GONE);

        findViewById(R.id.player_turn).setVisibility(View.GONE);

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
                if (findViewById(R.id.enemy_life).getLayoutParams().width < 100 || findViewById(R.id.player_life).getLayoutParams().width < 100) {
                    miron_q.setVisibility(View.GONE);
                    miron_act1_used.setVisibility(View.VISIBLE);
                }
                miron_q.setVisibility(View.VISIBLE);
                miron_act1_used.setVisibility(View.GONE);
                miron_act2_used.setVisibility(View.GONE);
                miron_act3_used.setVisibility(View.GONE);
                miron_act4_used.setVisibility(View.GONE);
                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (curret_life_enemy != 0 && curret_life_player != 0) {
                            miron_act1_used.setVisibility(View.GONE);
                            findViewById(R.id.player_turn).setVisibility(View.VISIBLE);
                        }

                    }
                }, 2000);

                findViewById(R.id.player_turn).setVisibility(View.GONE);

                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {

                            enemy_line_show.setVisibility(View.VISIBLE);
                            deleteHealthBar();
                            System.out.println(findViewById(R.id.player_life).getLayoutParams().width);
                        }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.GONE);
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        miron_q.setVisibility(View.VISIBLE);

                    }
                }, 6000);

                miron_q.setVisibility(View.VISIBLE);

            }
        });

        actionMiron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
                if (findViewById(R.id.enemy_life).getLayoutParams().width < 100 || findViewById(R.id.player_life).getLayoutParams().width < 100) {
                    miron_q.setVisibility(View.GONE);
                    miron_act2_used.setVisibility(View.VISIBLE);
                }
                miron_q.setVisibility(View.VISIBLE);
                miron_act1_used.setVisibility(View.GONE);
                miron_act2_used.setVisibility(View.GONE);
                miron_act3_used.setVisibility(View.GONE);
                miron_act4_used.setVisibility(View.GONE);
                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (curret_life_enemy != 0 && curret_life_player != 0) {
                            miron_act2_used.setVisibility(View.GONE);
                            findViewById(R.id.player_turn).setVisibility(View.VISIBLE);
                        }

                    }
                }, 2000);



                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.VISIBLE);
                        deleteHealthBar();
                        System.out.println(findViewById(R.id.player_life).getLayoutParams().width);
                    }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.GONE);
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        miron_q.setVisibility(View.VISIBLE);

                    }
                }, 6000);
                miron_q.setVisibility(View.VISIBLE);
            }
        });

        actionMiron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
                if (findViewById(R.id.enemy_life).getLayoutParams().width < 100 || findViewById(R.id.player_life).getLayoutParams().width < 100) {
                    miron_q.setVisibility(View.GONE);
                    miron_act3_used.setVisibility(View.VISIBLE);
                }
                miron_q.setVisibility(View.VISIBLE);
                miron_act1_used.setVisibility(View.GONE);
                miron_act2_used.setVisibility(View.GONE);
                miron_act3_used.setVisibility(View.GONE);
                miron_act4_used.setVisibility(View.GONE);
                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (curret_life_enemy != 0 && curret_life_player != 0) {
                            miron_act3_used.setVisibility(View.GONE);
                            findViewById(R.id.player_turn).setVisibility(View.VISIBLE);
                        }

                    }
                }, 2000);



                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.VISIBLE);
                        deleteHealthBar();
                        System.out.println(findViewById(R.id.player_life).getLayoutParams().width);
                    }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.GONE);
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        miron_q.setVisibility(View.VISIBLE);

                    }
                }, 6000);
                miron_q.setVisibility(View.VISIBLE);

            }
        });

        actionMiron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionMiron1.setVisibility(View.GONE);
                actionMiron2.setVisibility(View.GONE);
                actionMiron3.setVisibility(View.GONE);
                actionMiron4.setVisibility(View.GONE);
                if (findViewById(R.id.enemy_life).getLayoutParams().width < 100 || findViewById(R.id.player_life).getLayoutParams().width < 100) {
                    miron_q.setVisibility(View.GONE);
                    miron_act4_used.setVisibility(View.VISIBLE);
                }
                miron_q.setVisibility(View.VISIBLE);
                miron_act1_used.setVisibility(View.GONE);
                miron_act2_used.setVisibility(View.GONE);
                miron_act3_used.setVisibility(View.GONE);
                miron_act4_used.setVisibility(View.GONE);
                deleteEnemyHealthBar();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (curret_life_enemy != 0 && curret_life_player != 0) {
                            miron_act4_used.setVisibility(View.GONE);
                            findViewById(R.id.player_turn).setVisibility(View.VISIBLE);
                        }

                    }
                }, 2000);

                findViewById(R.id.player_turn).setVisibility(View.GONE);



                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.VISIBLE);
                        deleteHealthBar();
                        System.out.println(findViewById(R.id.player_life).getLayoutParams().width);
                    }
                }, 4000);

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {

                        enemy_line_show.setVisibility(View.GONE);
                        actionMiron1.setVisibility(View.VISIBLE);
                        actionMiron2.setVisibility(View.VISIBLE);
                        actionMiron3.setVisibility(View.VISIBLE);
                        actionMiron4.setVisibility(View.VISIBLE);
                        miron_q.setVisibility(View.VISIBLE);

                    }
                }, 6000);
                miron_q.setVisibility(View.VISIBLE);

            }
        });

    }

    private void goBackToGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void deleteHealthBar() {
        diff = (new Random().nextInt(4) + 1) * 100;
//        System.out.println(findViewById(R.id.player_life).getLayoutParams().width);
        curret_life_player = findViewById(R.id.player_life).getLayoutParams().width;
        if (curret_life_player > diff) {
            findViewById(R.id.player_life).getLayoutParams().width -= diff;
            System.out.println(curret_life_player + "life fr player current");
            miron_q.setVisibility(View.VISIBLE);
        }
        else {
            curret_life_player = 0;
        }
        if (curret_life_player == 0) {
            player_health.setVisibility(View.GONE);
            TextView tv1 = (TextView) findViewById(R.id.mesage);
            tv1.setText("You lost!");
            tv1.setVisibility(View.VISIBLE);
            goBackToGame();

//            actionMiron1.setVisibility(View.GONE);
//            actionMiron2.setVisibility(View.GONE);
//            actionMiron3.setVisibility(View.GONE);
//            actionMiron4.setVisibility(View.GONE);

//            final_msj.setVisibility(View.VISIBLE);

//            Handler handler2 = new Handler();
//            handler2.postDelayed(new Runnable() {
//                public void run() {
//                    goBackToGame();
//                }
//            }, 8000);
        }
        System.out.println(diff);
        System.out.println(findViewById(R.id.player_life).getLayoutParams().width + " atat are player dupa");
    }

    private void deleteEnemyHealthBar() {
        diff = (new Random().nextInt(4) + 1) * 100;
//        System.out.println(findViewById(R.id.enemy_life).getLayoutParams().width);
        curret_life_enemy = findViewById(R.id.enemy_life).getLayoutParams().width;
        if (curret_life_enemy >= diff) {
            findViewById(R.id.enemy_life).getLayoutParams().width -= diff;
            System.out.println(curret_life_enemy);
            miron_q.setVisibility(View.VISIBLE);

        }
        else {
            curret_life_enemy = 0;
        }


        if (curret_life_enemy == 0) {
            invalidateGame = true;
//                    goBackToGame();
            enemy_health.setVisibility(View.GONE);
            final_msj.setVisibility(View.VISIBLE);
            goBackToGame();

            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                public void run() {
//                            CatalogueActivity.biancaFoud = true;
                    if (invalidateGame) {
                        goBackToGame();
                    }
                }
            }, 2000);
        }

        if (invalidateGame) {
            final_msj.setVisibility(View.VISIBLE);
            goBackToGame();
        }
        System.out.println(diff);
        System.out.println(findViewById(R.id.enemy_life).getLayoutParams().width);
    }



}