package com.ojpp.devandroid.appgaseta.utils;

public class UtilsGasEta {

    public static String calcularMelhorOpcao(double gasolina, double etanol) {
        // preco da gasolina: € 5,12
        // preco do etanol: € 3,99

        // preco ideal = gasolina * 0.70

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if(etanol <= precoIdeal) {
            mensagemDeRetorno = "Abastecer com Etanol";
        } else {
            mensagemDeRetorno = "Abastecer com Gasolina";
        }

        // Se o preco do etanol for igual ou menor que o preco ideal,
        // melhor abastecer com etanol, caso contrario, a gasolina e
        // mais vantajoso
        return mensagemDeRetorno; // Abastecer com Gasolina - Abastecer com Etanol
    }
}
