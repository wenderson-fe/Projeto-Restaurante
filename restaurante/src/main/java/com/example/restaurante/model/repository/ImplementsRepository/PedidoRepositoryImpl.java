package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.entity.Pedido;
import com.example.restaurante.model.entity.PedidoCadastrado;
import com.example.restaurante.model.repository.InterfacesRepository.ItemPedidoRepository;
import com.example.restaurante.model.repository.InterfacesRepository.PedidoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepository {
    private ItemPedidoRepository itemPedidoRepository;

    public PedidoRepositoryImpl(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

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

                        itemPedidoRepository.cadastrarItemPedido(idPedido, idPrato);

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
    public List<PedidoCadastrado> listarPedido() {
        List<PedidoCadastrado> pedidos = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT id_pedido, data, hora, status, valor_total, id_funcionario, id_cliente, id_pagamento, quantidade FROM pedidos";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPedido = resultSet.getInt("id_pedido");
                Date data = resultSet.getDate("data");
                Time hora = resultSet.getTime("hora");
                String status = resultSet.getString("status");
                double valorTotal = resultSet.getDouble("valor_total");
                int idFuncionario = resultSet.getInt("id_funcionario");
                int idCliente = resultSet.getInt("id_cliente");
                int idPagamento = resultSet.getInt("id_pagamento");
                int quantidade = resultSet.getInt("quantidade");

                // Recuperar nomes associados aos IDs
                String nomeFuncionario = buscarNome(connection, "funcionarios", "nome", "id_funcionario", idFuncionario);
                String nomeCliente = buscarNome(connection, "clientes", "nome", "id_cliente", idCliente);
                String nomeFormaDePagamento = buscarNome(connection, "formas_de_pagamento", "nome", "id_pagamento", idPagamento);

                PedidoCadastrado pedidoCadastrado = new PedidoCadastrado(idPedido, data, hora, status, valorTotal, nomeFuncionario, nomeCliente, nomeFormaDePagamento, quantidade);

                // Recuperar itens para este pedido
                List<ItemPedido> itensPedido = itemPedidoRepository.listarItensPedido(idPedido, connection);
                pedidoCadastrado.setItensPedido(itensPedido);

                pedidos.add(pedidoCadastrado);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pedidos");
            e.printStackTrace();
        }

        return pedidos;
    }

    @Override
    public void atualizarPedido(Pedido novoDadoPedido, int pedido) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Buscar o ID do funcionário
            Integer idFuncionario = buscarId(connection, "funcionarios", "id_funcionario", novoDadoPedido.getFuncionario());
            if (idFuncionario == null) {
                System.out.println("Funcionário não encontrado");
                return;
            }

            // Buscar o ID do cliente
            Integer idCliente = buscarId(connection, "clientes", "id_cliente", novoDadoPedido.getCliente());
            if (idCliente == null) {
                System.out.println("Cliente não encontrado");
                return;
            }

            // Buscar o ID da forma de pagamento
            Integer idFormaDePagamento = buscarId(connection, "formas_de_pagamento", "id_pagamento", novoDadoPedido.getFormaDePagamento());
            if (idFormaDePagamento == null) {
                System.out.println("Forma de pagamento não encontrada");
                return;
            }

            // Buscar o ID prato e o preço do prato
            Integer idPrato = null;
            Double precoPrato = null;
            String sqlPrato = "SELECT id_prato, preco FROM pratos WHERE nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlPrato)) {
                statement.setString(1, novoDadoPedido.getPrato());
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
            double valorTotal = novoDadoPedido.getQuantidade() * precoPrato;

            // Atualizar o pedido
            String sql = "UPDATE pedidos SET data = ?, hora = ?, status = ?, valor_total = ?, id_funcionario = ?, id_cliente = ?, id_pagamento = ?, quantidade = ? WHERE id_pedido = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDate(1, novoDadoPedido.getData());
                statement.setTime(2, novoDadoPedido.getHora());
                statement.setString(3, novoDadoPedido.getStatus());
                statement.setDouble(4, valorTotal);
                statement.setInt(5, idFuncionario);
                statement.setInt(6, idCliente);
                statement.setInt(7, idFormaDePagamento);
                statement.setInt(8, novoDadoPedido.getQuantidade());
                statement.setInt(9, pedido);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Pedido atualizado com sucesso!");
                } else {
                    System.out.println("Não foi possível atualizar o pedido.");
                }

                itemPedidoRepository.atualizarItemPedido(idPrato, pedido);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pedido");
            e.printStackTrace();
        }
    }

    @Override
    public void deletarPedido(int pedidoExcluir) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Deletar os itens do pedido associados ao pedido
            itemPedidoRepository.deletarItemPedido(connection, pedidoExcluir);

            // Deletar o pedido
            String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, pedidoExcluir);

                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Pedido deletado com sucesso!");
                } else {
                    System.out.println("Não foi possível deletar o pedido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pedido");
            e.printStackTrace();
        }
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

    @Override
    public String buscarNome(Connection connection, String tabela, String colunaNome, String colunaId, int id) {
        String sql = "SELECT " + colunaNome + " FROM " + tabela + " WHERE " + colunaId + " = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(colunaNome);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar nome na tabela " + tabela);
            e.printStackTrace();
        }
        return null;
    }

}
