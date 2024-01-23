package com.ojpp.devandroid.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.ojpp.devandroid.applistacurso.model.Pessoa;
import com.ojpp.devandroid.applistacurso.view.MainActivity;

public class PessoaController {

    public static final String NOME_PREFERENCES = "pref_listavip";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {
        sharedPreferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = sharedPreferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.i("MVC_Controller", "Controller iniciado...");
        return super.toString();
    }

    public void salvar(@NonNull Pessoa pessoa) {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContacto", pessoa.getTelefoneContacto());
        listaVip.apply();
    }

    public Pessoa buscar() {

        Pessoa pessoa = new Pessoa();

        pessoa.setPrimeiroNome(sharedPreferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(sharedPreferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(sharedPreferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContacto(sharedPreferences.getString("telefoneContacto", ""));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

}
