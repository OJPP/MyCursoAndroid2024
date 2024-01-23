package com.ojpp.devandroid.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ojpp.devandroid.applistacurso.R;
import com.ojpp.devandroid.applistacurso.controller.PessoaController;
import com.ojpp.devandroid.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    public static final String NOME_PREFERENCES = "pref_listavip";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor listaVip;
    PessoaController pessoaController;
    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinaliar;
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = sharedPreferences.edit();

        pessoaController = new PessoaController();
        pessoaController.toString();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(sharedPreferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(sharedPreferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(sharedPreferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContacto(sharedPreferences.getString("telefoneContacto", ""));

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContacto());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinaliar = findViewById(R.id.btnFinaliar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

                listaVip.clear();
                listaVip.apply();
            }
        });

        btnFinaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContacto(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobrenome());
                listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefoneContacto", pessoa.getTelefoneContacto());
                listaVip.apply();

                pessoaController.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());

        int parada = 0;
    }

}