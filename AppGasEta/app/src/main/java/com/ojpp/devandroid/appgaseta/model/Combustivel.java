package com.ojpp.devandroid.appgaseta.model;

public class Combustivel {

    private String nomeDoCombustivel;
    private double precoDoCombustivel;
    private String recomendacao;

    public Combustivel() {
    }

    public Combustivel(String nomeDoCombustivel, double precoDoCombustivel, String recomendacao) {
        this.nomeDoCombustivel = nomeDoCombustivel;
        this.precoDoCombustivel = precoDoCombustivel;
        this.recomendacao = recomendacao;
    }

    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public void setNomeDoCombustivel(String nomeDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;
    }

    public double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public void setPrecoDoCombustivel(double precoDoCombustivel) {
        this.precoDoCombustivel = precoDoCombustivel;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    @Override
    public String toString() {
        return "Combustivel{" +
                "nomeDoCombustivel='" + nomeDoCombustivel + '\'' +
                ", precoDoCombustivel=" + precoDoCombustivel +
                ", recomendacao='" + recomendacao + '\'' +
                '}';
    }
}
