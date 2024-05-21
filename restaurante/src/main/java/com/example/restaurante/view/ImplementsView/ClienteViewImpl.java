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
                //cadastro();
                break;

            case 2:
                //atualizar();
                break;

            case 3:
                //deletar();
                break;

            case 4:
                //listar();
                break;

            case 5:
                //menuPrincipal();
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
                //gerenciaFuncionario();
                break;
        }


    }
}
