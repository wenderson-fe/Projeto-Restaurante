package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.repository.InterfacesRepository.PedidoRepository;

import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepository {
    @Override
    public void cadastrarPedido(Pedido pedido) {

    }

    @Override
    public List<Pedido> listarPedido() {
        return List.of();
    }

    @Override
    public void atualizarPedido(Pedido novoDadoPedido, String pedido) {

    }

    @Override
    public void deletarPedido(String pedidoExcluir) {

    }
}
