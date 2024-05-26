package com.example.restaurante.model.entity;

public class ItemPedido {
    private String nomeCliente;
    private String prato;

    public ItemPedido(String nomeCliente, String prato, int quantidade) {
        this.nomeCliente = nomeCliente;
        this.prato = prato;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getPrato() {
        return prato;
    }

}
