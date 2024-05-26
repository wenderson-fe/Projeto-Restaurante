package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.ItemPedidoController;
import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.repository.InterfacesRepository.ItemPedidoRepository;

public class ItemPedidoControllerImpl implements ItemPedidoController {
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoControllerImpl(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Override
    public void cadastrarItemPedido(String nomeCliente, String prato, int quantidade) {
        // Criar objeto de ItemPedido com as informações recebidas
        ItemPedido novoItemPedido = new ItemPedido(nomeCliente, prato, quantidade)
        // Adicionar o pedido ao repositório
        pedidoRepository.cadastrarPedido(novoPedido);
    }

    @Override
    public void atualizarItemPedido(String itemPedidoAtualizar, String nome, String prato, int quantidade) {

    }

    @Override
    public void deletarItemPedido(String itemPedidoExcluir) {

    }

    @Override
    public void listarItemPedido() {

    }
}
