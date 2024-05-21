package com.example.restaurante.controller.InterfacesController;

public interface FuncionarioController {
    void cadastrar(String nome, String cargo, String telefone, String email, double salario, String superior);
    void listar();
    void atualizar(String funcionarioAtualizar, String nome, String cargo, String telefone, String email, double salario, String superior);
    void deletar(String funcionarioExcluir);
}
