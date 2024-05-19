package com.example.restaurante.view;

import com.example.restaurante.controller.ControllerRestaurante;
import com.example.restaurante.controller.ControllerRestauranteImpl;
import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.repository.RepositorioRestaurante;

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
        int salario = sc.nextInt();
        System.out.println("Digite o nome do superior(se não hover deixe vazio): ");
        String superior = sc.nextLine();

    }

    // Método para sair do sistema
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



