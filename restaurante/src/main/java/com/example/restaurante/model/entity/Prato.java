package com.example.restaurante.model.entity;

public class Prato {
    private String nome;
    private String descricao;
    private double preco;

    public Prato (String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}
