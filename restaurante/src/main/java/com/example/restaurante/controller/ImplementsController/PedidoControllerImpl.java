package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.PedidoController;
import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.entity.PedidoCadastrado;
import com.example.restaurante.model.entity.Prato;
import com.example.restaurante.model.repository.InterfacesRepository.PedidoRepository;

import java.util.List;

public class PedidoControllerImpl implements PedidoController {
    private PedidoRepository pedidoRepository;

    public PedidoControllerImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void cadastrarPedido(String funcionario, String cliente, String formaDePagamento, String prato, int quantidade) {
        // Criar objeto de pedido com as informações recebidas
        Pedido novoPedido = new Pedido(funcionario, cliente, formaDePagamento, prato, quantidade);

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
    public void listarPedidos() {
        List<PedidoCadastrado> pedidosCadastrados = pedidoRepository.listarPedido();
        if (pedidosCadastrados.isEmpty()) {
            System.out.println("Não há pedidos cadastrados no momento.");
        } else {
            System.out.println("Pedidos cadastrados: ");
            for (PedidoCadastrado pedido : pedidosCadastrados) {
                System.out.println("Data: " + pedido.getDataCadastrado());
                System.out.println("Hora: " + pedido.getHoraCadastrado());
                System.out.println("Status: " + pedido.getStatusCadastrado());
                System.out.println("Funcionário: " + pedido.getNomeFuncionarioCadastrado());
                System.out.println("Cliente: " + pedido.getNomeClienteCadastrado());
                System.out.println("Forma de Pagamento: " + pedido.getNomeFormaDePagamentoCadastrado());
                System.out.println("Quantidade: " + pedido.getQuantidadeCadastrado());
                System.out.println("Valor Total: " + pedido.getValorTotalCadastrado());
                System.out.println("Itens do Pedido: ");
                for (ItemPedido item : pedido.getItensPedido()) {
                    //System.out.println("Cliente: " + item.getNomeCliente());
                    System.out.println("Prato: " + item.getPrato());
                }
                System.out.println("--------------------------------------");
            }
        }
    }

}
