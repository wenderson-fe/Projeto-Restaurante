package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.Cliente;

import java.util.List;

public interface ClienteRepository {
    void cadastrarCliente(Cliente cliente);
    List<Cliente> listarCliente();
    void atualizarCliente(Cliente novoDadoCliente, String cliente);
    void deletarCliente(String clienteExcluir);

}
