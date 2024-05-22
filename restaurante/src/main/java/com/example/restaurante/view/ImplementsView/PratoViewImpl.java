package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.controller.ImplementsController.PratoControllerImpl;
import com.example.restaurante.controller.InterfacesController.PratoController;
import com.example.restaurante.view.InterfacesView.PratoView;

import java.util.Scanner;

public class PratoViewImpl implements PratoView {
    private PratoController pratoController;

    public PratoViewImpl (PratoController pratoController) {
        this.pratoController = pratoController;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void gerenciaPrato() {
        //Gestão Pratos
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Cadastrar Prato");
        System.out.println("-------------------------------------");
        System.out.println("2. Atualizar dados de Prato");
        System.out.println("-------------------------------------");
        System.out.println("3. Excluir Prato");
        System.out.println("-------------------------------------");
        System.out.println("4. Listar Pratos");
        System.out.println("-------------------------------------");
        System.out.println("5. Voltar ao menu principal");
        System.out.println("-------------------------------------");
        System.out.println("Escolha:");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                cadastroPrato();
                break;

            case 2:
                atualizarPrato();
                break;

            case 3:
                deletarPrato();
                break;

            case 4:
                listarPrato();
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

    //Método para cadastrar prato
    @Override
    public void cadastroPrato() {
        //Receber informações de prato
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite a descrição: ");
        String descricao = sc.nextLine();
        System.out.println("Digite o preço: ");
        double preco = sc.nextDouble();

        pratoController.cadastrarPrato(nome, descricao, preco);
    }

    //Método para atualizar informações de prato
    @Override
    public void atualizarPrato() {
        pratoController.listarPrato();
        System.out.println("Digite o nome do prato para atualizar as informações: ");
        String pratoAtualizar = sc.nextLine();

        System.out.println("Digite o novo nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite a nova descrição: ");
        String descricao = sc.nextLine();
        System.out.println("Digite o novo preço: ");
        double preco = sc.nextDouble();

        pratoController.atualizarPrato(pratoAtualizar, nome, descricao, preco);
    }

    //Método para deletar prato
    @Override
    public void deletarPrato() {
        pratoController.listarPrato();

        System.out.println("Digite o nome do prato que deseja excluir: ");
        String pratoExcluir = sc.nextLine();

        pratoController.deletarPrato(pratoExcluir);
    }

    //Método para listar pratos
    @Override
    public void listarPrato() {
        pratoController.listarPrato();
    }

    //Método para voltar ao menu principal
    @Override
    public void menuPrincipal() {

    }
}
