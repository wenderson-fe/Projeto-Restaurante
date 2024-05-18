package com.example.restaurante.view;

import java.util.Scanner;

public class ViewRestauranteImpl implements ViewRestaurante {
    Scanner sc = new Scanner(System.in);

    @Override
    public void exibirMenu() {
        //Exibe as opções do sistema
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Gerenciamento de Clientes");
        System.out.println("-------------------------------------");
        System.out.println("2. Gerenciamento de Funcionários");
        System.out.println("-------------------------------------");
        System.out.println("3. Gerenciamento de Pedidos");
        System.out.println("-------------------------------------");
        System.out.println("4. Gerenciamento de Itens do Pedido");
        System.out.println("-------------------------------------");
        System.out.println("5. Gerenciamento de Pratos");
        System.out.println("-------------------------------------");
        System.out.println("6. Sair do Sistema");
        System.out.println("-------------------------------------");
    }

    @Override
    public void executarOpcao(int n) {
        //Captura a opção escolhida pelo usuário.
        switch (n) {
            case 2:
                gerenciaFuncionario();
                break;
            case 6:
                saindoDoSistema();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    //Gestão funcionario
    @Override
    public void gerenciaFuncionario() {
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("-------------------------------------");
        System.out.println("2. Atualizar dados de Funcionário");
        System.out.println("-------------------------------------");
        System.out.println("3. Excluir Funcionário");
        System.out.println("-------------------------------------");
        System.out.println("4. Listar Funcionário");
        System.out.println("-------------------------------------");
        System.out.println("Escolha:");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                cadastroFuncionario();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    // Método para cadastrar um funcionário
    public void cadastroFuncionario() {
        System.out.println("nome");
    }

    // Método para sair do sistema
    public boolean saindoDoSistema() {
        //Sai do sistema
        System.out.println("Você realmente deseja sair do sistema? (S/N)");
        String resposta = sc.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Saindo do sistema...");
            return true;
        } else if (resposta.equalsIgnoreCase("N")) {
            System.out.println("Operação de saída cancelada.");
            return false;
        } else {
            System.out.println("Opção inválida. Operação de saída cancelada.");
            return false;
        }
    }
}



