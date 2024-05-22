package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.controller.InterfacesController.PagamentoController;
import com.example.restaurante.view.InterfacesView.PagamentoView;

import java.util.Scanner;

public class PagamentoViewImpl implements PagamentoView {
    private PagamentoController pagamentoController;

    public PagamentoViewImpl (PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }
    Scanner sc = new Scanner(System.in);

    @Override
    public void gerenciaPagamento() {
        //Gestão Pagamentos
        System.out.println("----------------- Menu ------------------");
        System.out.println("1. Cadastrar Forma de Pagamento");
        System.out.println("-----------------------------------------");
        System.out.println("2. Atualizar dados de Forma de Pagamento");
        System.out.println("-----------------------------------------");
        System.out.println("3. Excluir Forma de Pagamento");
        System.out.println("-----------------------------------------");
        System.out.println("4. Listar Formas de Pagamento");
        System.out.println("-----------------------------------------");
        System.out.println("5. Voltar ao menu principal");
        System.out.println("-----------------------------------------");
        System.out.println("Escolha:");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                cadastroPagamento();
                break;

            case 2:
                atualizarPagamento();
                break;

            case 3:
                deletarPagamento();
                break;

            case 4:
                listarPagamento();
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

    //Método para cadastrar forma de pagamento
    @Override
    public void cadastroPagamento() {
        //Receber informações de forma de pagamento
        System.out.println("Digite o nome: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a taxa: ");
        String taxa = sc.nextLine();

        pagamentoController.cadastrarFormaPagamento(descricao, taxa);
    }

    //Método para atualizar informações de forma de pagamento
    @Override
    public void atualizarPagamento() {
        pagamentoController.listarFormaPagamento();

        System.out.println("Digite o nome da forma de pagamento para atualizar as informações: ");
        String pagamentoAtualizar = sc.nextLine();

        System.out.println("Digite o novo nome: ");
        String descricao = sc.nextLine();
        System.out.println("Digite a nova taxa: ");
        String taxa = sc.nextLine();

        pagamentoController.atualizarFormaPagamento(pagamentoAtualizar, descricao, taxa);
    }

    @Override
    public void deletarPagamento() {
        pagamentoController.listarFormaPagamento();

        System.out.println("Digite o nome da forma de pagamento de deseja excluir: ");
        String pagamentoExcluir = sc.nextLine();

        pagamentoController.deletarFormaPagamento(pagamentoExcluir);
    }

    //Método para listar as formas de pagamento
    @Override
    public void listarPagamento() {
        pagamentoController.listarFormaPagamento();
    }

    @Override
    public void menuPrincipal() {

    }
}
