package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.entity.PedidoCadastrado;
import com.example.restaurante.model.entity.Prato;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PedidoRepository {
    void cadastrarPedido(Pedido pedido);
    List<PedidoCadastrado> listarPedido();
    void atualizarPedido(Pedido novoDadoPedido, String pedido);
    void deletarPedido(String pedidoExcluir);
    Integer buscarId(Connection connection, String nomeTabela, String nomeCampoId, String nome);
    String buscarNome(Connection connection, String tabela, String colunaNome, String colunaId, int id);
}
