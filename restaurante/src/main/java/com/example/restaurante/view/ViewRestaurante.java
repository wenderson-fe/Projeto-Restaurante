package com.example.restaurante.view;

public interface ViewRestaurante {
    void exibirMenu();
    void executarOpcao(int n);
    void saindoDoSistema();

    //Gestão funcionario
    void gerenciaFuncionario();
    void cadastro();
    void listar();
    void atualizar();
    void deletar();
}
