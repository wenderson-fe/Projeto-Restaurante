package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.Pagamento;
import com.example.restaurante.model.entity.Prato;
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

    }

    @Override
    public void deletarFormaPagamento(String pagamentoExcluir) {

    }
}
