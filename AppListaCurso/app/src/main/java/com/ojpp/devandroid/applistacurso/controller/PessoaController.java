package com.ojpp.devandroid.applistacurso.controller;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ojpp.devandroid.applistacurso.model.Pessoa;
import com.ojpp.devandroid.applistacurso.view.MainActivity;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.i("MVC_Controller", "Controller iniciado...");
        return super.toString();
    }

    public void salvar(@NonNull Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());
    }
}
