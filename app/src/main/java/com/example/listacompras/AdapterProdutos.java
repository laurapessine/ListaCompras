package com.example.listacompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
public class AdapterProdutos extends ArrayAdapter<Produto> {
    private Context context;
    private ArrayList<Produto> produtos;

    public AdapterProdutos(Context context, ArrayList<Produto> produtos) {
        super(context, R.layout.item_lista, produtos);
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_lista, parent, false);

        TextView tvNomeProduto = itemView.findViewById(R.id.tvNomeProduto);
        TextView tvMarcaProduto = itemView.findViewById(R.id.tvMarcaProduto);
        TextView tvQuantidadeProduto = itemView.findViewById(R.id.tvQuantidadeProduto);
        TextView tvComprado = itemView.findViewById(R.id.tvComprado);

        tvNomeProduto.setText(produtos.get(position).getNome());
        tvMarcaProduto.setText(produtos.get(position).getMarca());
        tvQuantidadeProduto.setText(produtos.get(position).getQuantidade());
        tvComprado.setText(produtos.get(position).getComprado());

        return itemView;
    }
}
