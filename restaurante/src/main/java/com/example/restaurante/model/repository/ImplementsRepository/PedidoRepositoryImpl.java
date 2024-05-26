package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.repository.InterfacesRepository.ItemPedidoRepository;
import com.example.restaurante.model.repository.InterfacesRepository.PedidoRepository;

import java.sql.*;
import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepository {

    @Override
    public void cadastrarPedido(Pedido pedido) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Buscar o ID do funcionário
            Integer idFuncionario = buscarId(connection, "funcionarios", "id_funcionario", pedido.getFuncionario());
            if (idFuncionario == null) {
                System.out.println("Funcionário não encontrado");
                return;
            }

            // Buscar o ID do cliente
            Integer idCliente = buscarId(connection, "clientes", "id_cliente", pedido.getCliente());
            if (idCliente == null) {
                System.out.println("Cliente não encontrado");
                return;
            }

            // Buscar o ID da forma de pagamento
            Integer idFormaDePagamento = buscarId(connection, "formas_de_pagamento", "id_pagamento", pedido.getFormaDePagamento());
            if (idFormaDePagamento == null) {
                System.out.println("Forma de pagamento não encontrada");
                return;
            }

            // Buscar o ID prato e o preço do prato
            Integer idPrato = null;
            Double precoPrato = null;
            String sqlPrato = "SELECT id_prato, preco FROM pratos WHERE nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlPrato)) {
                statement.setString(1, pedido.getPrato());
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        idPrato = rs.getInt("id_prato");
                        precoPrato = rs.getDouble("preco");
                    }
                }
            }
            if (idPrato == null) {
                System.out.println("Prato não encontrado");
                return;
            }

            // Calcular o valor total
            double valorTotal = pedido.getQuantidade() * precoPrato;

            // Inserir o pedido
            String sql = "INSERT INTO pedidos (data, hora, status, valor_total, id_funcionario, id_cliente, id_pagamento, quantidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setDate(1, pedido.getData());
                statement.setTime(2, pedido.getHora());
                statement.setDouble(4, valorTotal);
                statement.setString(3, pedido.getStatus());
                statement.setInt(5, idFuncionario);
                statement.setInt(6, idCliente);
                statement.setInt(7, idFormaDePagamento);
                statement.setInt(8, pedido.getQuantidade());

                statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPedido = generatedKeys.getInt(1);

                        ItemPedidoRepositoryImpl itemPedidoRepo = new ItemPedidoRepositoryImpl();
                        itemPedidoRepo.cadastrarItemPedido(idPedido, idPrato);

                        System.out.println("Pedido cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao obter o ID do pedido inserido.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar pedido");
            e.printStackTrace();
        }


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

    @Override
    public Integer buscarId(Connection connection, String nomeTabela, String nomeCampoId, String nome) {
        String sql = "SELECT " + nomeCampoId + " FROM " + nomeTabela + " WHERE nome = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(nomeCampoId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ID na tabela " + nomeTabela + " para o nome " + nome);
            e.printStackTrace();
        }
        return null;
    }

}
