package com.example.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

@SuppressWarnings("FieldCanBeLocal")
public class DigitaActivity extends AppCompatActivity {

    private Button btnInserir, btnCancelar;
    private EditText txtNome, txtMarca, txtQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digita);

        btnInserir = findViewById(R.id.btnInserir);
        btnCancelar = findViewById(R.id.btnCancelar);
        txtNome = findViewById(R.id.txtNome);
        txtMarca = findViewById(R.id.txtMarca);
        txtQuantidade = findViewById(R.id.txtQuantidade);

        btnInserir.setOnClickListener(view -> {
            Intent intent = new Intent();

            String nome = txtNome.getText().toString();
            String marca = txtMarca.getText().toString();
            String quantidade = txtQuantidade.getText().toString();
            String comprado = "";

            intent.putExtra("nome", nome);
            intent.putExtra("marca", marca);
            intent.putExtra("quantidade", quantidade);
            intent.putExtra("comprado", comprado);

            setResult(RESULT_OK, intent);

            finish();
        });

        btnCancelar.setOnClickListener(view -> finish());

    }
}