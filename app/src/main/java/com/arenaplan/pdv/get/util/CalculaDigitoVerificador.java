package com.arenaplan.pdv.get.util;

public class CalculaDigitoVerificador {

    public static String calculaDigitoVerificador(String chave) {

        String digitoVerificador = "";

        int intNumero = 0;
        int intTotalNumero = 0;
        int intResto = 0;
        int intMultiplicador = 9;
        int num;

        for( int i = chave.length() -1; i >= 0; i--) {

          char c =  chave.charAt(i);
          num = Integer.parseInt(String.valueOf(c));
          intNumero = num * intMultiplicador;
          intTotalNumero = intTotalNumero + intNumero;
          if(intMultiplicador > 2) {
              intMultiplicador = intMultiplicador - 1;
          } else {
              intMultiplicador = 9;
          }

        }

        intResto = intTotalNumero % 11;

        switch (intResto) {

            case 0 :
            case 10:
                digitoVerificador = "0";
                break;

            default:
                digitoVerificador = String.valueOf(intResto);
                break;
        }


        return digitoVerificador;
    }
}
