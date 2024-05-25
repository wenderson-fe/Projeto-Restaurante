package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.entity.Prato;

import java.util.List;

public interface ItemPedidoRepository {
    void cadastrarItemPedido(ItemPedido itemPedido);
    List<ItemPedido> listarItensPedido();
    void atualizarItemPedido(ItemPedido novoDadoItemPedido, String itemPedido);
    void deletarItemPedido(String itemPedidoExcluir);
}
