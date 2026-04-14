package com.arenaplan.pdv.get.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Monetario {

    public static String converteValorFloatParaReal(float valor) {

        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        return valorString;

    }

    public static String convertValorDuasCasas(float valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return  df.format(valor);
    }

    public static String converteValorRetornoGetNetParaReal(String valor) {

        try {
            float converteValor = Float.parseFloat(valor);
            float incluiCasasDecimais = (float) (converteValor * 0.01);
            Locale ptBr = new Locale("pt", "BR");
            return NumberFormat.getCurrencyInstance(ptBr).format(incluiCasasDecimais);
        } catch (Exception e) {
            return  valor;
        }
    }
}
