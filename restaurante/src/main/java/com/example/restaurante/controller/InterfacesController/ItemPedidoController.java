package com.example.restaurante.controller.InterfacesController;

public interface ItemPedidoController {
    void atualizarItemPedido(String itemPedidoAtualizar, String nome, String prato, int quantidade);
    void deletarItemPedido(String itemPedidoExcluir);
    void listarItemPedido();
}
