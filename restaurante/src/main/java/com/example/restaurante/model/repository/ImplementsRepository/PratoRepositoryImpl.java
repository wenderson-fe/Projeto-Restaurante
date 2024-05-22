package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.Prato;
import com.example.restaurante.model.repository.InterfacesRepository.PratoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PratoRepositoryImpl implements PratoRepository {
    @Override
    public void cadastrarPrato(Prato prato) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Inserir o novo prato
            String sql = "INSERT INTO pratos (nome, descricao, preco) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prato.getNome());
                statement.setString(2, prato.getDescricao());
                statement.setDouble(3, prato.getPreco());

                statement.executeUpdate();
                System.out.println("Prato cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Prato");
            e.printStackTrace();
        }

    }

    @Override
    public List<Prato> listarPrato() {
        //Listar Pratos
        List<Prato> pratosCadastrados = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT nome, descricao, preco FROM pratos";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                double preco = resultSet.getDouble("preco");

                Prato prato = new Prato(nome, descricao, preco);
                pratosCadastrados.add(prato);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar pratos");
            e.printStackTrace();
        }

        return pratosCadastrados;
    }

    @Override
    public void atualizarPrato(Prato novoDadoPrato, String prato) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se o prato existe
            String sql = "SELECT COUNT(*) AS count FROM pratos WHERE nome = ?";
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sql)) {
                verificarExistencia.setString(1, prato);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        if (count == 0) {
                            System.out.println("Prato não encontrado.");
                            return;
                        }
                    }
                }
            }

            // Atualiza os dados do prato
            String sqlAtualizar = "UPDATE pratos SET nome = ?, descricao = ?, preco = ? WHERE nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlAtualizar)) {
                statement.setString(1, novoDadoPrato.getNome());
                statement.setString(2, novoDadoPrato.getDescricao());
                statement.setDouble(3, novoDadoPrato.getPreco());
                statement.setString(4, prato);

                statement.executeUpdate();
                System.out.println("Dados do prato atualizados com sucesso!");

            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados do prato!");
            e.printStackTrace();
        }
    }

    @Override
    public void deletarPrato(String pratoExcluir) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se o prato existe
            String sqlVerificarExistencia = "SELECT id_prato FROM pratos WHERE nome = ?";
            Integer idPrato = null;
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sqlVerificarExistencia)) {
                verificarExistencia.setString(1, pratoExcluir);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        idPrato = rs.getInt("id_prato");
                    } else {
                        System.out.println("Prato não encontrado.");
                        return;
                    }
                }
            }

            // Exclui o prato
            String sqlDeletar = "DELETE FROM pratos WHERE id_prato = ?";
            try (PreparedStatement deletarPrato = connection.prepareStatement(sqlDeletar)) {
                deletarPrato.setInt(1, idPrato);
                deletarPrato.executeUpdate();
                System.out.println("Prato excluído com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir prato!");
            e.printStackTrace();
        }
    }
}
