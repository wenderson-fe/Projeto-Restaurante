package com.example.restaurante.model.repository.ImplementsRepository;

import com.example.restaurante.model.ConexaoBanco.DatabaseConnection;
import com.example.restaurante.model.entity.Cliente;
import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.repository.InterfacesRepository.ClienteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {

    @Override
    public void cadastrarCliente(Cliente cliente) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Inserir o novo cliente
            String sql = "INSERT INTO clientes (nome, endereco, telefone) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, cliente.getNome());
                statement.setString(2, cliente.getEndereco());
                statement.setString(3, cliente.getTelefone());

                statement.executeUpdate();
                System.out.println("Cliente cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente");
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listarCliente() {
        //Listar Clientes
        List<Cliente> clientesCadastrados = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT nome, endereco, telefone FROM clientes";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String telefone = resultSet.getString("telefone");

                Cliente cliente = new Cliente(nome, endereco, telefone);
                clientesCadastrados.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes");
            e.printStackTrace();
        }

        return clientesCadastrados;
    }

    @Override
    public void atualizarCliente(Cliente novoDadoCliente, String cliente) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se o cliente existe
            String sql = "SELECT COUNT(*) AS count FROM clientes WHERE nome = ?";
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sql)) {
                verificarExistencia.setString(1, cliente);
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

            // Atualiza os dados do cliente
            String sqlAtualizar = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ? WHERE nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlAtualizar)) {
                statement.setString(1, novoDadoCliente.getNome());
                statement.setString(2, novoDadoCliente.getEndereco());
                statement.setString(3, novoDadoCliente.getTelefone());
                statement.setString(4, cliente);

                statement.executeUpdate();
                System.out.println("Dados do cliente atualizados com sucesso!");

            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados do cliente");
            e.printStackTrace();
        }
    }

    @Override
    public void deletarCliente(String clienteExcluir) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Verifica se o cliente existe
            String sqlVerificarExistencia = "SELECT id_cliente FROM clientes WHERE nome = ?";
            Integer idCliente = null;
            try (PreparedStatement verificarExistencia = connection.prepareStatement(sqlVerificarExistencia)) {
                verificarExistencia.setString(1, clienteExcluir);
                try (ResultSet rs = verificarExistencia.executeQuery()) {
                    if (rs.next()) {
                        idCliente = rs.getInt("id_cliente");
                    } else {
                        System.out.println("Cliente não encontrado.");
                        return;
                    }
                }
            }

            // Exclui o cliente
            String sqlDeletar = "DELETE FROM clientes WHERE id_cliente = ?";
            try (PreparedStatement deletarFuncionario = connection.prepareStatement(sqlDeletar)) {
                deletarFuncionario.setInt(1, idCliente);
                deletarFuncionario.executeUpdate();
                System.out.println("Cliente excluído com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente!");
            e.printStackTrace();
        }
    }

}
