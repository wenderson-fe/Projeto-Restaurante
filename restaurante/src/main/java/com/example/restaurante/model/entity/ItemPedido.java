package com.example.restaurante.model.entity;

public class ItemPedido {
    private String nome;
    private String prato;
    private int quantidade;

    public ItemPedido(String nome, String prato, int quantidade) {
        this.nome = nome;
        this.prato = prato;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
