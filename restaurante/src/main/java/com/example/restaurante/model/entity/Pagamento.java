package com.example.restaurante.model.entity;

public class Pagamento {
    private String descricao;
    private String taxa;

    public Pagamento(String descricao, String taxa) {
        this.descricao = descricao;
        this.taxa = taxa;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTaxa() {
        return taxa;
    }

}
