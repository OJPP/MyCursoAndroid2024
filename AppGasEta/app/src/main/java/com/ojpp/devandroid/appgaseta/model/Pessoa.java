package com.ojpp.devandroid.appgaseta.model;

public class Pessoa {

    private String primeiroNome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefoneContacto;

    public Pessoa() {
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContacto() {
        return telefoneContacto;
    }

    public void setTelefoneContacto(String telefoneContacto) {
        this.telefoneContacto = telefoneContacto;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefoneContacto='" + telefoneContacto + '\'' +
                '}';
    }
}
