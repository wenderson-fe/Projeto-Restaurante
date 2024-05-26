package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.entity.Prato;

import java.sql.Connection;
import java.util.List;

public interface ItemPedidoRepository {
    void cadastrarItemPedido(int idPedido, int idPrato);
    List<ItemPedido> listarItensPedido();
    void atualizarItemPedido(ItemPedido novoDadoItemPedido, String itemPedido);
    void deletarItemPedido(String itemPedidoExcluir);
    Integer buscarId(Connection connection, String nomeTabela, String nomeCampoId, String nome);
}
