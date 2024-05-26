package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.entity.Prato;

import java.sql.Connection;
import java.util.List;

public interface ItemPedidoRepository {
    void cadastrarItemPedido(int idPedido, int idPrato);
    List<ItemPedido> listarItensPedido(int idPedido, Connection connection);
    void atualizarItemPedido(int idPrato, int idPedido);
    void deletarItemPedido(Connection connection, int itemPedidoExcluir);
    Integer buscarId(Connection connection, String nomeTabela, String nomeCampoId, String nome);
    String buscarNome(Connection connection, String tabela, String colunaNome, String colunaId, int id);
}
