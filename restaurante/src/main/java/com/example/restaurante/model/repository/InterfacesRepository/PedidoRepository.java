package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.entity.Prato;

import java.util.List;

public interface PedidoRepository {
    void cadastrarPedido(Pedido pedido);
    List<Pedido> listarPedido();
    void atualizarPedido(Pedido novoDadoPedido, String pedido);
    void deletarPedido(String pedidoExcluir);
}
