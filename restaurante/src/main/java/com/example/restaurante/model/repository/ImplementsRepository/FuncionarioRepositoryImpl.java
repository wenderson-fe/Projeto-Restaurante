package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.repository.InterfacesRepository.FuncionarioRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {
        try (Connection connection = DatabaseConnection.getConnection()) {
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
                            return;
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

    @Override
    public List<Funcionario> listarFuncionario() {
        //Listar Funcionários
        List<Funcionario> funcionariosCadastrados = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT f.nome, f.cargo, f.telefone, f.email, f.salario, " +
                    "CASE WHEN f.id_superior IS NOT NULL THEN s.nome ELSE 'Não possui superior' END AS superior " +
                    "FROM funcionarios f LEFT JOIN funcionarios s ON f.id_superior = s.id_funcionario";


            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");
                String telefone = resultSet.getString("telefone");
                String email = resultSet.getString("email");
                Double salario = resultSet.getDouble("salario");
                String superior = resultSet.getString("superior");

                Funcionario funcionario = new Funcionario(nome, cargo, telefone, email, salario, superior);
                funcionariosCadastrados.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários");
            e.printStackTrace();
        }

        return funcionariosCadastrados;
    }

    @Override
    public void atualizarFuncionario(Funcionario novoDadoFuncionario, String funcionario) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se o funcionário existe
            String sql = "SELECT COUNT(*) AS count FROM funcionarios WHERE nome = ?";
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sql)) {
                verificarExistencia.setString(1, funcionario);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        if (count == 0) {
                            System.out.println("Funcionário não encontrado.");
                            return;
                        }
                    }
                }
            }

            // Atualiza os dados do funcionário
            String sqlAtualizar = "UPDATE funcionarios SET nome = ?, cargo = ?, telefone = ?, email = ?, salario = ?, id_superior = ? WHERE nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlAtualizar)) {
                statement.setString(1, novoDadoFuncionario.getNome());
                statement.setString(2, novoDadoFuncionario.getCargo());
                statement.setString(3, novoDadoFuncionario.getTelefone());
                statement.setString(4, novoDadoFuncionario.getEmail());
                statement.setDouble(5, novoDadoFuncionario.getSalario());

                // Busca o ID do superior se não for "gerente"
                Integer idSuperior = null;
                if (!"gerente".equalsIgnoreCase(novoDadoFuncionario.getSuperior())) {
                    String sqlBuscaIdSuperior = "SELECT id_funcionario FROM funcionarios WHERE nome = ?";
                    try (PreparedStatement buscaIdStatement = connection.prepareStatement(sqlBuscaIdSuperior)) {
                        buscaIdStatement.setString(1, novoDadoFuncionario.getSuperior());
                        try (ResultSet rs = buscaIdStatement.executeQuery()) {
                            if (rs.next()) {
                                idSuperior = rs.getInt("id_funcionario");
                            } else {
                                System.out.println("Superior não encontrado");
                                return;
                            }
                        }
                    }
                }

                if (idSuperior == null) {
                    statement.setNull(6, java.sql.Types.INTEGER);
                } else {
                    statement.setInt(6, idSuperior);
                }

                statement.setString(7, funcionario);
                statement.executeUpdate();
                System.out.println("Dados do funcionário atualizados com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados do funcionário");
            e.printStackTrace();
        }
    }

    @Override
    public void deletarFuncionario(String funcionarioExcluir) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se o funcionário existe
            String sqlVerificarExistencia = "SELECT id_funcionario FROM funcionarios WHERE nome = ?";
            Integer idFuncionario = null;
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sqlVerificarExistencia)) {
                verificarExistencia.setString(1, funcionarioExcluir);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        idFuncionario = rs.getInt("id_funcionario");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                        return;
                    }
                }
            }

            // Atualizar os funcionários que possuem o funcionário a ser excluído como superior
            String sqlAtualizarFuncionarios = "UPDATE funcionarios SET id_superior = NULL WHERE id_superior = ?";
            try (PreparedStatement atualizarFuncionarios = connection.prepareStatement(sqlAtualizarFuncionarios)) {
                atualizarFuncionarios.setInt(1, idFuncionario);
                atualizarFuncionarios.executeUpdate();
            }

            // Exclui o funcionário
            String sqlDeletar = "DELETE FROM funcionarios WHERE id_funcionario = ?";
            try (PreparedStatement deletarFuncionario = connection.prepareStatement(sqlDeletar)) {
                deletarFuncionario.setInt(1, idFuncionario);
                deletarFuncionario.executeUpdate();
                System.out.println("Funcionário excluído com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário");
            e.printStackTrace();
        }
    }

}