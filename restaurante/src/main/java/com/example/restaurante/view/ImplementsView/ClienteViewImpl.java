package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.controller.InterfacesController.ClienteController;
import com.example.restaurante.view.InterfacesView.ClienteView;

import java.util.Scanner;

public class ClienteViewImpl implements ClienteView {
    private ClienteController clienteController;

    public ClienteViewImpl(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void gerenciaCliente() {
        //Gestão Cliente
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("-------------------------------------");
        System.out.println("2. Atualizar dados de Cliente");
        System.out.println("-------------------------------------");
        System.out.println("3. Excluir Cliente");
        System.out.println("-------------------------------------");
        System.out.println("4. Listar Cliente");
        System.out.println("-------------------------------------");
        System.out.println("5. Voltar ao menu principal");
        System.out.println("-------------------------------------");
        System.out.println("Escolha:");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                cadastroCliente();
                break;

            case 2:
                atualizarCliente();
                break;

            case 3:
                deletarCliente();
                break;

            case 4:
                listarCliente();
                break;

            case 5:
                menuPrincipal();
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
                //gerenciaFuncionario();
                break;
        }


    }

    //Método para cadastrar Cliente
    @Override
    public void cadastroCliente() {
        //Receber informações do cliente
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite seu endereço: ");
        String endereco = sc.nextLine();
        System.out.println("Digite o telefone: ");
        String telefone = sc.nextLine();

        clienteController.cadastrarCliente(nome, endereco, telefone);

    }

    //Método para atualizar dados do cliente
    @Override
    public void atualizarCliente() {
        clienteController.listarCliente();
        System.out.println("Digite o nome do cliente para atualizar as informações: ");
        String clienteAtualizar = sc.nextLine();

        System.out.println("Digite o novo nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o novo endereço: ");
        String endereco = sc.nextLine();
        System.out.println("Digite o novo telefone");
        String telefone = sc.nextLine();

        clienteController.atualizarCliente(clienteAtualizar, nome, endereco, telefone);
    }

    //Método para excluir cliente
    @Override
    public void deletarCliente() {
        clienteController.listarCliente();
        System.out.println("Digite o nome do cliente que deseja excluir: ");
        String clienteExcluir = sc.nextLine();

        clienteController.deletarCliente(clienteExcluir);

    }

    //Método para listar clientes cadastrados
    @Override
    public void listarCliente() {
        clienteController.listarCliente();
    }

    @Override
    public void menuPrincipal() {

    }


}
