package com.ojpp.devandroid.applistacurso.controller;

import com.ojpp.devandroid.applistacurso.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List<Curso> listaDeCursos;

    public List<Curso> getListaDeCursos() {
        listaDeCursos.add(new Curso("Java")); // Java
        listaDeCursos.add(new Curso("HTML")); // HTML
        listaDeCursos.add(new Curso("C#")); // C#
        listaDeCursos.add(new Curso("Python")); // Python
        listaDeCursos.add(new Curso("PHP"));
        listaDeCursos.add(new Curso("Java EE"));
        listaDeCursos.add(new Curso("Flutter"));
        listaDeCursos.add(new Curso("Dart"));

        return listaDeCursos;
    }

    public ArrayList<String> dadosParaSpinner() {
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size(); i++) {
            Curso curso = getListaDeCursos().get(i);
            dados.add(curso.getNomeDoCursoDesejado());
        }
        return dados;
    }
}
