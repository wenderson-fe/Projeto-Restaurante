package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.view.InterfacesView.*;

import java.util.Scanner;

public class InterfaceViewImpl implements InterfaceView {
    private FuncionarioView funcionarioView;
    private ClienteView clienteView;
    private PratoView pratoView;
    private PagamentoView pagamentoView;
    private PedidoView pedidoView;

    public InterfaceViewImpl(FuncionarioView funcionarioView, ClienteView clienteView, PratoView pratoView,
    PagamentoView pagamentoView, PedidoView pedidoView) {
        this.funcionarioView = funcionarioView;
        this.clienteView = clienteView;
        this.pratoView = pratoView;
        this.pagamentoView = pagamentoView;
        this.pedidoView = pedidoView;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void exibirMenu() {
        //Exibe as opções do sistema
        System.out.println("----------------- Menu ------------------");
        System.out.println("1. Gerenciamento de Clientes");
        System.out.println("-----------------------------------------");
        System.out.println("2. Gerenciamento de Funcionários");
        System.out.println("-----------------------------------------");
        System.out.println("3. Gerenciamento de Pedidos");
        System.out.println("-----------------------------------------");
        System.out.println("4. Gerenciamento de Pratos");
        System.out.println("-----------------------------------------");
        System.out.println("5. Gerenciamento de Formas de Pagamento");
        System.out.println("-----------------------------------------");
        System.out.println("6. Sair do Sistema");
        System.out.println("-----------------------------------------");
    }

    @Override
    public void executarOpcao(int n) {
        //Captura a opção escolhida pelo usuário.
        switch (n) {
            case 1:
                clienteView.gerenciaCliente();
                break;

            case 2:
                funcionarioView.gerenciaFuncionario();
                break;

            case 3:
                pedidoView.gerenciaPedido();
                break;

            case 4:
                pratoView.gerenciaPrato();
                break;

            case 5:
                pagamentoView.gerenciaPagamento();
                break;

            case 6:
                saindoDoSistema();
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    // Método para sair do sistema
    @Override
    public void saindoDoSistema() {
        System.out.println("Você realmente deseja sair do sistema? (S/N)");
        String resposta = sc.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Saindo do sistema...");
            System.exit(0);
        } else if (resposta.equalsIgnoreCase("N")) {
            System.out.println("Operação de saída cancelada.");

        } else {
            System.out.println("Opção inválida. Operação de saída cancelada.");
        }

    }

}



