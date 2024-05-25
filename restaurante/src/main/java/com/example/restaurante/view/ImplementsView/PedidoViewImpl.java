package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.controller.ImplementsController.PedidoControllerImpl;
import com.example.restaurante.controller.InterfacesController.PedidoController;
import com.example.restaurante.view.InterfacesView.PedidoView;

import java.util.Scanner;

public class PedidoViewImpl implements PedidoView {
    private PedidoController pedidoController;

    public PedidoViewImpl (PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }


    Scanner sc = new Scanner(System.in);

    @Override
    public void gerenciaPedido() {
        //Gestão Pedidos
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Cadastrar Pedido");
        System.out.println("-------------------------------------");
        System.out.println("2. Atualizar dados de Pedido");
        System.out.println("-------------------------------------");
        System.out.println("3. Excluir Pedido");
        System.out.println("-------------------------------------");
        System.out.println("4. Listar Pedidos");
        System.out.println("-------------------------------------");
        System.out.println("5. Voltar ao menu principal");
        System.out.println("-------------------------------------");
        System.out.println("Escolha:");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                //cadastroPrato();
                break;

            case 2:
                //atualizarPrato();
                break;

            case 3:
                //deletarPrato();
                break;

            case 4:
                //listarPrato();
                break;

            case 5:
                menuPrincipal();
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    @Override
    public void cadastroPedido() {

    }

    @Override
    public void atualizarPedido() {

    }

    @Override
    public void deletarPedido() {

    }

    @Override
    public void listarPedido() {

    }

    @Override
    public void menuPrincipal() {

    }
}
