package com.arenaplan.pdv.get.util;

public class DadosGetNet {

    public static String converteTipo(String tipo) {
        switch (tipo) {
            case "02":
                return "Débito";
            case "11":
                return "Crédito a vista";
            case "12":
                return "Crédito parcelado Lojista";
            case "13":
                return "Crédito parcelado Emissor";
            case "03":
                return "Voucher";
            default:
                return "Não Identificado";
        }
    }

    public static String converteInputType(String value) {
        switch (value) {

            case "021":
                return "tarja magnética";
            case "051":
                return "Chip";
            case "071":
                return "chip sem contato";
            case "801":
                return "tarja magnética - fallback";
            default:
                return "Não Identificado";

        }

    }
}
