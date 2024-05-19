package com.example.restaurante.model.repository;

import com.example.restaurante.model.entity.Funcionario;

import java.sql.*;

public class RepositorioRestauranteImpl implements RepositorioRestaurante {

    @Override
    public void cadastrar(Funcionario funcionario) {
        String url = "jdbc:postgresql://localhost:5432/restaurante";
        String user = "postgres";
        String password = "47557609";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Buscar o ID do superior se não for "gerente"
            Integer idSuperior = null;
            if (!"gerente".equalsIgnoreCase(funcionario.getSuperior())) {
                String sqlBuscaIdSuperior = "SELECT id_funcionario FROM funcionarios WHERE nome = ?";
                try (PreparedStatement buscaIdStatement = connection.prepareStatement(sqlBuscaIdSuperior)) {
                    buscaIdStatement.setString(1, funcionario.getSuperior());
                    try (ResultSet rs = buscaIdStatement.executeQuery()) {
                        if (rs.next()) {
                            idSuperior = rs.getInt("id_funcionario");
                        } else {
                            System.out.println("Superior não encontrado");
                            return; // Ou pode lançar uma exceção ou lidar com o caso de outra forma
                        }
                    }
                }
            }

            // Inserir o novo funcionário
            String sql = "INSERT INTO funcionarios (nome, cargo, telefone, email, salario, id_superior) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, funcionario.getNome());
                statement.setString(2, funcionario.getCargo());
                statement.setString(3, funcionario.getTelefone());
                statement.setString(4, funcionario.getEmail());
                statement.setDouble(5, funcionario.getSalario());

                if (idSuperior == null) {
                    statement.setNull(6, java.sql.Types.INTEGER);
                } else {
                    statement.setInt(6, idSuperior);
                }

                statement.executeUpdate();
                System.out.println("Funcionário cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionário");
            e.printStackTrace();
        }
    }
}
