package com.example.restaurante.controller.InterfacesController;

public interface PedidoController {
    void cadastrarPedido(String funcionario, String cliente, String formaDePagamento);
    void atualizarPedido(String pedidoAtualizar, String funcionario, String cliente, String formaDePagamento);
    void deletarPedido(String pedidoExcluir);
    void listarPrato();
}
