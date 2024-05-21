package com.example.restaurante.controller.InterfacesController;

public interface FuncionarioController {
    void cadastrarFuncionario(String nome, String cargo, String telefone, String email, double salario, String superior);
    void listarFuncionario();
    void atualizarFuncionario(String funcionarioAtualizar, String nome, String cargo, String telefone, String email, double salario, String superior);
    void deletarFuncionario(String funcionarioExcluir);
}
