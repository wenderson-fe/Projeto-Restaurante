package com.example.restaurante.view;

import com.example.restaurante.controller.ControllerRestaurante;

import java.util.Scanner;

public class ViewRestauranteImpl implements ViewRestaurante {
    private ControllerRestaurante controllerRestaurante;

    public ViewRestauranteImpl(ControllerRestaurante controllerRestaurante) {
        this.controllerRestaurante = controllerRestaurante;
    }

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
            case 1:
                gerenciamentoCliente();
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

    // -----------------------------------------------------------------------------------------------------------------
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
        System.out.println("5. Voltar ao menu principal");
        System.out.println("-------------------------------------");
        System.out.println("Escolha:");
        int escolha = sc.nextInt();
        sc.nextLine();

        switch (escolha) {
            case 1:
                cadastro();
                break;

            case 2:
                atualizar();
                break;

            case 3:
                deletar();
                break;

            case 4:
                listar();
                break;

            case 5:
                menuPrincipal();
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
                gerenciaFuncionario();
                break;
        }
    }

    // Método para cadastrar um funcionário
    public void cadastro() {
        //Receber informações do funcionário
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o cargo: ");
        String cargo = sc.nextLine();
        System.out.println("Digite o telefone: ");
        String telefone = sc.nextLine();
        System.out.println("Digite o E-mail: ");
        String email = sc.nextLine();
        System.out.println("Digite o salário: ");
        double salario = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite o nome do superior (se não hover escreva gerente): ");
        String superior = sc.nextLine();

        controllerRestaurante.cadastrar(nome, cargo, telefone, email, salario, superior);

    }

    @Override
    public void listar() {
        controllerRestaurante.listar();
    }

    @Override
    public void atualizar() {
        controllerRestaurante.listar();
        System.out.println("Digite o nome do funcionário para atualizar as informações: ");
        String funcionarioAtualizar = sc.nextLine();

        System.out.println("Digite o novo nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o novo cargo: ");
        String cargo = sc.nextLine();
        System.out.println("Digite o novo telefone: ");
        String telefone = sc.nextLine();
        System.out.println("Digite o novo E-mail: ");
        String email = sc.nextLine();
        System.out.println("Digite o novo salário: ");
        double salario = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite o nome do superior (se não hover escreva gerente): ");
        String superior = sc.nextLine();

        controllerRestaurante.atualizar(funcionarioAtualizar, nome, cargo, telefone, email, salario, superior);
    }

    @Override
    public void deletar() {
        controllerRestaurante.listar();
        System.out.println("Digite o nome do funcionário que deseja excluir: ");
        String funcionarioExcluir = sc.nextLine();

        controllerRestaurante.deletar(funcionarioExcluir);
    }

    //------------------------------------------------------------------------------------------------------------------
    //Gestão Cliente
    @Override
    public void gerenciamentoCliente() {
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
                cadastro();
                break;

            case 2:
                atualizar();
                break;

            case 3:
                deletar();
                break;

            case 4:
                listar();
                break;

            case 5:
                menuPrincipal();
                System.out.println("Voltando ao menu principal...");
                break;

            default:
                System.out.println("Opção inválida!");
                gerenciaFuncionario();
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

    //Método para voltar ao menu principal
    @Override
    public void menuPrincipal() {
        exibirMenu();
    }
}



