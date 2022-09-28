package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class EnemyManagement {

    public static List<String> biancaLines = new ArrayList<>(
            List.of("Ce faceti dragilooor?",
                    ":)",
                    "Meeting scurt de aliniere",
                    "Imbratiseaza schimbarea"));

    public static List<String> carolinaLines = new ArrayList<>(
            List.of("Facem sa mearga?",
                    "Nu mancam si noi ceva bun?",
                    "HR goes brrr",
                    "Prajituri la bucatarie!"));

    public static List<String> dorinLines = new ArrayList<>(
            List.of("Punem un task",
                    "Div-ul e cu 3 px prea pe stanga",
                    "The cake is a lie",
                    "NU ara ca-n design"));

    public static List<String> lipanLines = new ArrayList<>(
            List.of("Ce faceti chiftelute?",
                    "Ce e basina asta?",
                    "Pe scurt ca am treaba",
                    "Ce sparti sunteti"));

    public static List<String> lucianLines = new ArrayList<>(
            List.of("Aveti 5 min sa vb despre Spark?",
                    "Log this",
                    "Stii, Cassandra:",
                    "Dar Kafka:"));

    public static List<String> popoviciLines = new ArrayList<>(
            List.of("Avem contract?",
                    "E bine de tot",
                    "Sunt distrus!",
                    "Mamaa maaama"));

    public static List<String> srpLines = new ArrayList<>(
            List.of("Da-i din linia de comanda",
                    "Golan(g)",
                    "Sah mat si poarta-n casa",
                    "F***m tot!"));

    public static List<String> tanaLines = new ArrayList<>(
            List.of("Hai ca daca asa e, asa facem",
                    "Seeeexy",
                    "Lasa ba ca merge si-asa",
                    "Vara ispitelor"));

    static List<Enemy> listOfEnemies = new ArrayList<>(
            List.of(new Enemy("Bianca", R.drawable.bianca, biancaLines, false),
                    new Enemy("Carolina", R.drawable.carolina, carolinaLines, false),
                    new Enemy("Dorin", R.drawable.dorin, dorinLines, false),
                    new Enemy("Lipan", R.drawable.lipan, lipanLines, false),
                    new Enemy("Lucian", R.drawable.lucian, lucianLines, false),
                    new Enemy("Popovici", R.drawable.popovici, popoviciLines, false),
                    new Enemy("SRP", R.drawable.srp, srpLines, false),
                    new Enemy("Tana", R.drawable.tana, tanaLines, false))
    );
}
