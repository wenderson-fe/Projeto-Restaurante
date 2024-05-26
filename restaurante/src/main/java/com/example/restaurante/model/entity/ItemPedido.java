package com.example.restaurante.model.entity;

public class ItemPedido {
    private String nomeCliente;
    private String prato;
    private int quantidade;

    public ItemPedido(String nomeCliente, String prato, int quantidade) {
        this.nomeCliente = nomeCliente;
        this.prato = prato;
        this.quantidade = quantidade;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
