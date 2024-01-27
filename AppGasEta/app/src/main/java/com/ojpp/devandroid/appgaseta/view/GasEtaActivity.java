package com.ojpp.devandroid.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ojpp.devandroid.appgaseta.R;
import com.ojpp.devandroid.appgaseta.model.Combustivel;
import com.ojpp.devandroid.appgaseta.utils.UtilsGasEta;

public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editEtanol;
    TextView txtResultado;
    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }

                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editGasolina.setError("* Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }

                if (isDadosOk) {
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilsGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    txtResultado.setText(recomendacao);
                } else {
                    Toast.makeText(GasEtaActivity.this,
                            "Por favor, digite os dados obrigatórios...",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGasolina.setText("");
                editEtanol.setText("");
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Desabilitar o botao salvar
                combustivelGasolina = new Combustivel(
                        "Gasolina",
                        precoGasolina,
                        UtilsGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                combustivelEtanol = new Combustivel(
                        "Etanol",
                        precoEtanol,
                        UtilsGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                int parada = 0;
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "GasEta boa econimia...", Toast.LENGTH_LONG).show();
                finish();
            }
        });
//      Toast.makeText(this, UtilsGasEta.calcularMelhorOpcao(5.12, 3.39), Toast.LENGTH_SHORT).show();

    }
}
