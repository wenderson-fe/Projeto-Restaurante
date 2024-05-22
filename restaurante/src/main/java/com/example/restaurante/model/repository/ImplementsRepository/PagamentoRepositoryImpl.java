package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.Pagamento;
import com.example.restaurante.model.repository.InterfacesRepository.PagamentoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepositoryImpl implements PagamentoRepository {
    @Override
    public void cadastrarFormaPagamento(Pagamento pagamento) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Inserir o nova forma de pagamento
            String sql = "INSERT INTO formas_de_pagamento (descricao, taxa) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, pagamento.getDescricao());
                statement.setString(2, pagamento.getTaxa());

                statement.executeUpdate();
                System.out.println("Forma de pagamento cadastrada com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar forma de pagamento!");
            e.printStackTrace();
        }

    }

    @Override
    public List<Pagamento> listarFormaPagamento() {
        //Listar forma de pagamento
        List<Pagamento> formasDePagamento = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT descricao, taxa FROM formas_de_pagamento";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                String taxa = resultSet.getString("taxa");

                Pagamento pagamento = new Pagamento(descricao, taxa);
                formasDePagamento.add(pagamento);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar formas de pagamento!");
            e.printStackTrace();
        }

        return formasDePagamento;
    }

    @Override
    public void atualizarFormaPagamento(Pagamento novoDadoPagamento, String pagamento) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se a forma de pagamento existe
            String sql = "SELECT COUNT(*) AS count FROM formas_de_pagamento WHERE descricao = ?";
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sql)) {
                verificarExistencia.setString(1, pagamento);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        if (count == 0) {
                            System.out.println("Forma de pagamento não encontrada.");
                            return;
                        }
                    }
                }
            }

            // Atualiza os dados de forma de pagamento
            String sqlAtualizar = "UPDATE formas_de_pagamento SET descricao = ?, taxa = ? WHERE descricao = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlAtualizar)) {
                statement.setString(1, novoDadoPagamento.getDescricao());
                statement.setString(2, novoDadoPagamento.getTaxa());
                statement.setString(3, pagamento);

                statement.executeUpdate();
                System.out.println("Dados de forma de pagamento atualizados com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados de forma de pagamento!");
            e.printStackTrace();
        }
    }

    @Override
    public void deletarFormaPagamento(String pagamentoExcluir) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se a forma de pagamento existe
            String sqlVerificarExistencia = "SELECT id_pagamento FROM formas_de_pagamento WHERE descricao = ?";
            Integer idPagamento = null;
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sqlVerificarExistencia)) {
                verificarExistencia.setString(1, pagamentoExcluir);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        idPagamento = rs.getInt("id_pagamento");
                    } else {
                        System.out.println("Forma de pagamento não encontrado.");
                        return;
                    }
                }
            }

            // Exclui o pagamento
            String sqlDeletar = "DELETE FROM formas_de_pagamento WHERE id_pagamento = ?";
            try (PreparedStatement deletarPrato = connection.prepareStatement(sqlDeletar)) {
                deletarPrato.setInt(1, idPagamento);
                deletarPrato.executeUpdate();
                System.out.println("Forma de pagamento excluída com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir forma de pagamento!");
            e.printStackTrace();
        }
    }
}
