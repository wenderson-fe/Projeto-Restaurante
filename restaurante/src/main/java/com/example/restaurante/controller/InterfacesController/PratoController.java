package com.example.restaurante.controller.InterfacesController;

public interface PratoController {
    void cadastrarPrato(String nome, String descricao, double preco);
    void atualizarPrato(String pratoAtualizar, String nome, String descricao, double preco);
    void deletarPrato(String pratoExcluir);
    void listarPrato();
}
