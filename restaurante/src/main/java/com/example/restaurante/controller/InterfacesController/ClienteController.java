package com.example.restaurante.controller.InterfacesController;

public interface ClienteController {
    void gerenciaCliente();

    void cadastrarCliente(String nome, String endereco, String telefone);
    void atualizarCliente(String clienteAtualizar, String nome, String endereco, String telefone);
    void deletarCliente(String clienteExcluir);
    void listarCliente();

}
