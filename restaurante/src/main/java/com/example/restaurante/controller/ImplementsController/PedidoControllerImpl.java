package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.PedidoController;
import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.entity.Prato;
import com.example.restaurante.model.repository.InterfacesRepository.PedidoRepository;

public class PedidoControllerImpl implements PedidoController {
    private PedidoRepository pedidoRepository;

    public PedidoControllerImpl (PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void cadastrarPedido(String funcionario, String cliente, String formaDePagamento) {
        // Criar objeto de pedido com as informações recebidas
        Pedido novoPedido = new Pedido(funcionario, cliente, formaDePagamento);

        // Adicionar o pedido ao repositório
        pedidoRepository.cadastrarPedido(novoPedido);
    }

    @Override
    public void atualizarPedido(String pedidoAtualizar, String funcionario, String cliente, String formaDePagamento) {

    }

    @Override
    public void deletarPedido(String pedidoExcluir) {

    }

    @Override
    public void listarPrato() {

    }
}
