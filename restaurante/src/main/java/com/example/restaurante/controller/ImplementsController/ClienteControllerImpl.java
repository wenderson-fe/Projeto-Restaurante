package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.ClienteController;
import com.example.restaurante.model.entity.Cliente;
import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.repository.InterfacesRepository.ClienteRepository;

import java.util.List;

public class ClienteControllerImpl implements ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteControllerImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void gerenciaCliente() {

    }

    @Override
    public void cadastrarCliente(String nome, String endereco, String telefone) {
        //Criar objeto do cliente com as informações recebidas
        Cliente novoCliente = new Cliente(nome, endereco, telefone);

        //Adicionar cliente ao repositório
        clienteRepository.cadastrarCliente(novoCliente);
    }

    @Override
    public void atualizarCliente(String clienteAtualizar, String nome, String endereco, String telefone) {
        Cliente novoDadoCliente = new Cliente(nome, endereco, telefone);

        clienteRepository.atualizarCliente(novoDadoCliente, clienteAtualizar);
    }

    @Override
    public void deletarCliente(String clienteExcluir) {
        clienteRepository.deletarCliente(clienteExcluir);


    }

    @Override
    public void listarCliente() {
        //Chama o método "listarCliente" e obtém seu retorno
        List<Cliente> clientesCadastrados = clienteRepository.listarCliente();
        if (clientesCadastrados.isEmpty()) {
            System.out.println("Não há clientes cadastrados no momento.");
        } else {
            System.out.println("Clientes cadastrados");
            for (Cliente cliente : clientesCadastrados) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("--------------------------------------");
            }
        }

    }
}
