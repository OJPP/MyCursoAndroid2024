package com.ojpp.devandroid.appgaseta.controller;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.ojpp.devandroid.appgaseta.model.Combustivel;
import com.ojpp.devandroid.appgaseta.model.Pessoa;
import com.ojpp.devandroid.appgaseta.view.GasEtaActivity;
import com.ojpp.devandroid.appgaseta.view.MainActivity;

public class CombustivelController {

    public static final String NOME_PREFERENCES = "pref_gaseta";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dadosPreferences;

    public CombustivelController(GasEtaActivity gasEtaActivity) {
        sharedPreferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = sharedPreferences.edit();
    }

    public void salvar(@NonNull Combustivel combustivel) {
        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("precoDoCombustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendaçao", combustivel.getRecomendacao());
        dadosPreferences.apply();
    }

    public void limpar() {
        dadosPreferences.clear();
        dadosPreferences.apply();
    }

}
