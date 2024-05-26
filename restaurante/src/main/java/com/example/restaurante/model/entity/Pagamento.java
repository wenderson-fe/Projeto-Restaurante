package com.example.restaurante.model.entity;

public class Pagamento {
    private String nome;
    private String taxa;

    public Pagamento(String nome, String taxa) {
        this.nome = nome;
        this.taxa = taxa;
    }

    public String getNome() {
        return nome;
    }

    public String getTaxa() {
        return taxa;
    }

}
