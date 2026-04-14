package com.arenaplan.pdv.get.util;


import java.text.DecimalFormat;

public class PreparaIdentificadorFiscal {

    public static String preparaIdentificadorFiscal(String value) {

        DecimalFormat df = new DecimalFormat("000000000");
        return df.format(Integer.parseInt(value));

    }

    public static String preparaHH(String value) {

        DecimalFormat df = new DecimalFormat("000");
        return df.format(Integer.parseInt(String.valueOf(value)));
    }
}
