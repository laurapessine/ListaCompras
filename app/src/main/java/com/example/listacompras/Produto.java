package com.example.listacompras;

@SuppressWarnings("FieldMayBeFinal")
public class Produto {
    private String nome, marca, quantidade, comprado;

    public Produto(String nome, String marca, String quantidade, String comprado) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.comprado = comprado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public String getComprado() {
        return this.comprado;
    }

    public void setComprado(String comprado) { this.comprado = comprado; }
}
