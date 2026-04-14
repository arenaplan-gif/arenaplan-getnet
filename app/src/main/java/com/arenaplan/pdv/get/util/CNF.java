package com.arenaplan.pdv.get.util;

import java.util.Random;

public class CNF {

    public static String getRandomicoCNF() {

        Random random = new Random();
        int digRandomicoUm = random.nextInt(9);
        int digRandomicoDois = random.nextInt(9);
        int digRandomicoTres = random.nextInt(9);
        int digRandomicoQuatro = random.nextInt(9);

        StringBuilder value = new StringBuilder();

        value.append(digRandomicoUm);
        value.append(digRandomicoDois);
        value.append(digRandomicoTres);
        value.append(digRandomicoQuatro);

        return  value.toString();
    }
}
