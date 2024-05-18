package com.example.restaurante.view;

public interface ViewRestaurante {
    void exibirMenu();
    void executarOpcao(int n);
    boolean saindoDoSistema();

    //Gestão funcionario
    void gerenciaFuncionario();
    void cadastroFuncionario();
}
