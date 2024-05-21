package com.example.restaurante.view.ImplementsView;

import com.example.restaurante.controller.InterfacesController.FuncionarioController;
import com.example.restaurante.view.InterfacesView.FuncionarioView;

import java.util.Scanner;

public class FuncionarioViewImpl implements FuncionarioView {
    private FuncionarioController funcionarioController;

    public FuncionarioViewImpl(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
    }

    Scanner sc = new Scanner(System.in);

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
                cadastroFuncionario();
                break;

            case 2:
                atualizarFuncionario();
                break;

            case 3:
                deletarFuncionario();
                break;

            case 4:
                listarFuncionario();
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
        double salario = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite o nome do superior (se não hover escreva gerente): ");
        String superior = sc.nextLine();

        funcionarioController.cadastrarFuncionario(nome, cargo, telefone, email, salario, superior);

    }

    @Override
    public void listarFuncionario() {
        funcionarioController.listarFuncionario();
    }

    @Override
    public void atualizarFuncionario() {
        funcionarioController.listarFuncionario();
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

        funcionarioController.atualizarFuncionario(funcionarioAtualizar, nome, cargo, telefone, email, salario, superior);
    }

    @Override
    public void deletarFuncionario() {
        funcionarioController.listarFuncionario();
        System.out.println("Digite o nome do funcionário que deseja excluir: ");
        String funcionarioExcluir = sc.nextLine();

        funcionarioController.deletarFuncionario(funcionarioExcluir);
    }

    @Override
    public void menuPrincipal() {
        //ViewInterface voltarMenu = new ViewInterface;
        //voltarMenu.exibirMenu();

    }
}
