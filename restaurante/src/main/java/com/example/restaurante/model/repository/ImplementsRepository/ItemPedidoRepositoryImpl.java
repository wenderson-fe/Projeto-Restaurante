package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.ItemPedido;
import com.example.restaurante.model.repository.InterfacesRepository.ItemPedidoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoRepositoryImpl implements ItemPedidoRepository {
    @Override
    public void cadastrarItemPedido(int idPedido, int idPrato) {
        String sql = "INSERT INTO itens_pedido (id_pedido, id_prato) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPedido);
            statement.setInt(2, idPrato);

            statement.executeUpdate();

            System.out.println("Item do pedido cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar item do pedido");
            e.printStackTrace();
        }
    }

    @Override
    public List<ItemPedido> listarItensPedido(int idPedido, Connection connection) {
        List<ItemPedido> itensPedido = new ArrayList<>();

        String sql = "SELECT id_prato FROM itens_pedido WHERE id_pedido = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPedido);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //int idCliente = resultSet.getInt("id_cliente");
                int idPrato = resultSet.getInt("id_prato");

                // Buscar o nome do cliente
                //String nomeCliente = buscarNome(connection, "clientes", "nome", "id_cliente", idCliente);

                // Buscar o nome do prato
                String nomePrato = buscarNome(connection, "pratos", "nome", "id_prato", idPrato);

                ItemPedido itemPedido = new ItemPedido(nomePrato);
                itensPedido.add(itemPedido);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar itens do pedido");
            e.printStackTrace();
        }

        return itensPedido;
    }

    @Override
    public void atualizarItemPedido(int idPrato, int idPedido) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Atualizar o item do pedido
            String sql = "UPDATE itens_pedido SET id_prato = ? WHERE id_pedido = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idPrato);
                statement.setInt(2, idPedido);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Item do pedido atualizado com sucesso!");
                } else {
                    System.out.println("Não foi possível atualizar o item do pedido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar item do pedido");
            e.printStackTrace();
        }
    }

    @Override
    public void deletarItemPedido(Connection connection, int itemPedidoExcluir) {
        try {
            String sql = "DELETE FROM itens_pedido WHERE id_pedido = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, itemPedidoExcluir);

                int rowsDeleted = statement.executeUpdate();

                System.out.println(rowsDeleted + " itens de pedido deletados");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar itens do pedido");
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
