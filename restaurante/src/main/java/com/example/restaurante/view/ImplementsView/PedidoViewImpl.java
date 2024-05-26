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
                cadastroPedido();
                break;

            case 2:
                atualizarPedido();
                break;

            case 3:
                deletarPedido();
                break;

            case 4:
                listarPedidos();
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
        //Receber informações de pedido
        System.out.println("Digite o nome do funcionário: ");
        String funcionario = sc.nextLine();
        System.out.println("Digite o nome do cliente: ");
        String cliente = sc.nextLine();
        System.out.println("Digite a forma de pagamento: ");
        String formaDePagamento = sc.nextLine();
        System.out.println("Digite o prato: ");
        String prato = sc.nextLine();
        System.out.println("Digite a quantidade: ");
        int quantidade = sc.nextInt();

        pedidoController.cadastrarPedido(funcionario, cliente, formaDePagamento, prato, quantidade);
    }

    @Override
    public void atualizarPedido() {
        pedidoController.listarPedidos();

        System.out.println("Digite o id do pedido para atualizar as informações: ");
        int pedidoAtualizar = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o novo nome do funcionário: ");
        String funcionario = sc.nextLine();
        System.out.println("Digite o novo nome do cliente: ");
        String cliente = sc.nextLine();
        System.out.println("Digite a nova forma de pagamento: ");
        String formaDePagamento = sc.nextLine();
        System.out.println("Digite o novo prato: ");
        String prato = sc.nextLine();
        System.out.println("Digite a nova quantidade: ");
        int quantidade = sc.nextInt();

        pedidoController.atualizarPedido(pedidoAtualizar, funcionario,cliente, formaDePagamento, prato, quantidade);


    }

    @Override
    public void deletarPedido() {
        pedidoController.listarPedidos();

        System.out.println("Digite o id do pedido que deseja excluir: ");
        int idPedido = sc.nextInt();

        pedidoController.deletarPedido(idPedido);
    }

    @Override
    public void listarPedidos() {
        pedidoController.listarPedidos();
    }

    @Override
    public void menuPrincipal() {

    }
}
