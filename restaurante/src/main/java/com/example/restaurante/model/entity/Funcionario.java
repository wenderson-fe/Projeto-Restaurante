package com.example.restaurante.model.entity;

public class Funcionario {
    private String nome;
    private String cargo;
    private int telefone;
    private String email;
    private double salario;
    private String superior;

    public Funcionario (String nome, String cargo, int telefone, String email, double salario, String superior) {
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
        this.salario = salario;
        this.superior = superior;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public double getSalario() {
        return salario;
    }

    public String getSuperior() {
        return superior;
    }

}
