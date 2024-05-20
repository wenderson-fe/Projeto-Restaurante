package com.example.restaurante.controller;

public interface ControllerRestaurante {
    void cadastrar(String nome, String cargo, String telefone, String email, double salario, String superior);
    void listar();
    void atualizar(String funcionarioAtualizar, String nome, String cargo, String telefone, String email, double salario, String superior);
    void deletar(String funcionarioExcluir);
}
