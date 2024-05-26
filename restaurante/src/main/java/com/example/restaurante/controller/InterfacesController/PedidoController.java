package com.example.restaurante.controller.InterfacesController;

public interface PedidoController {
    void cadastrarPedido(String funcionario, String cliente, String formaDePagamento, String prato, int quantidade);
    void atualizarPedido(int pedidoAtualizar, String funcionario, String cliente, String formaDePagamento, String prato, int quantidade);
    void deletarPedido(int pedidoExcluir);
    void listarPedidos();
}
