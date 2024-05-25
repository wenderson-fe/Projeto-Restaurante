package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.controller.InterfacesController.ItemPedidoController;
import com.example.restaurante.view.InterfacesView.ItemPedidoView;

import java.util.Scanner;

public class ItemPedidoViewImpl implements ItemPedidoView {
    private ItemPedidoController itemPedidoController;

    public ItemPedidoViewImpl (ItemPedidoController itemPedidoController) {
        this.itemPedidoController = itemPedidoController;
    }

    Scanner sc = new Scanner(System.in);


    @Override
    public void gerenciaItemPedido() {
        //Gestão Item Pedido
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Cadastrar Item Pedido");
        System.out.println("-------------------------------------");
        System.out.println("2. Atualizar dados de Item Pedido");
        System.out.println("-------------------------------------");
        System.out.println("3. Excluir Item Pedido");
        System.out.println("-------------------------------------");
        System.out.println("4. Listar Itens Pedidos");
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
               // atualizarPrato();
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
    public void cadastroItemPedido() {

    }

    @Override
    public void atualizarItemPedido() {

    }

    @Override
    public void deletarItemPedido() {

    }

    @Override
    public void listarItemPedido() {

    }

    @Override
    public void menuPrincipal() {

    }
}
