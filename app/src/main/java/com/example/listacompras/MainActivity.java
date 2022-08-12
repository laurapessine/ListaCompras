/* Laura e Evandro */

package com.example.listacompras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
public class MainActivity extends AppCompatActivity {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private AdapterProdutos adaptador;

    private Button btnAdiciona;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdiciona = findViewById(R.id.btnAdiciona);
        lista = findViewById(R.id.lista);

        btnAdiciona.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DigitaActivity.class);
            startActivityForResult(intent, 1);
        });

        adaptador = new AdapterProdutos(this, produtos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener((adapterView, view, i, l) -> {
            Produto produto = produtos.get(i);

            if (produto.getComprado().equals("")) {
                produto.setComprado("* COMPRADO *");
            } else {
                produto.setComprado("");
            }
            adaptador.notifyDataSetChanged();
        });

        lista.setOnItemLongClickListener((adapterView, view, i, l) -> {
            produtos.remove(i);
            adaptador.notifyDataSetChanged();
            return true;
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String nome = data.getStringExtra("nome");
                String marca = data.getStringExtra("marca");
                String quantidade = data.getStringExtra("quantidade");
                String comprado = data.getStringExtra("comprado");
                Produto produto = new Produto(nome, marca, quantidade, comprado);

                produtos.add(produto);
                adaptador.notifyDataSetChanged();

            }
        }
    }

}