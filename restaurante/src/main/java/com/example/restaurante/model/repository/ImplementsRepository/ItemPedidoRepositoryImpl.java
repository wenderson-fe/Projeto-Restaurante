package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.repository.InterfacesRepository.ItemPedidoRepository;

import java.util.List;

public class ItemPedidoRepositoryImpl implements ItemPedidoRepository {
    @Override
    public void cadastrarItemPedido(ItemPedido itemPedido) {

    }

    @Override
    public List<ItemPedido> listarItensPedido() {
        return List.of();
    }

    @Override
    public void atualizarItemPedido(ItemPedido novoDadoItemPedido, String itemPedido) {

    }

    @Override
    public void deletarItemPedido(String itemPedidoExcluir) {

    }
}
