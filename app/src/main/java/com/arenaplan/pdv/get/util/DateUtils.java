package com.arenaplan.pdv.get.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static String pattern = "dd/MM/yyyy'";
    private static String hora = "HH:mm";

    private static String horaGetNet = "MMDDhhmmss";

    public static String retornaDiaAtual() {

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date currentTime = Calendar.getInstance().getTime();

        return data.format(currentTime);

    }

    public static String retornaHoraAtual() {
        Date currentTime = Calendar.getInstance().getTime();

        SimpleDateFormat data = new SimpleDateFormat(hora, Locale.getDefault());
        return data.format(currentTime);
    }

    public static String pegaAnoAtual() {

        Date currentTime = Calendar.getInstance().getTime();

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        String dataConvertida = data.format(currentTime);

        String[] dataParam = dataConvertida.split("/");

        String ano = dataParam[2];

        String anoRetorno = ano.substring(ano.length() - 2);

        return  anoRetorno;


    }

    public static  String pegaMesAtual() {

        Date currentTime = Calendar.getInstance().getTime();

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        String dataConvertida = data.format(currentTime);

        String[] dataParam = dataConvertida.split("/");

        String mes = dataParam[1];

        return  mes;
    }

    public static String converteHoraGetNet(String valor) {

        try {
            SimpleDateFormat data = new SimpleDateFormat(horaGetNet, Locale.getDefault());

            SimpleDateFormat dataRetorno = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());

            return  dataRetorno.format(data);

        } catch (Exception e) {
            return valor;
        }

    }

}
