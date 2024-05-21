package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.FuncionarioController;
import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.repository.InterfacesRepository.FuncionarioRepository;

import java.util.List;

public class FuncionarioControllerImpl implements FuncionarioController {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioControllerImpl(FuncionarioRepository repositoryFuncionario) {
        this.funcionarioRepository = repositoryFuncionario;
    }

    @Override
    public void cadastrar(String nome, String cargo, String telefone, String email, double salario, String superior) {
        // Criar objeto do funcionário com as informações recebidas
        Funcionario novoFuncionario = new Funcionario(nome, cargo, telefone, email, salario, superior);

        // Adicionar o funcionario ao repositório
        funcionarioRepository.cadastrar(novoFuncionario);

    }

    @Override
    public void listar() {
        //Chama o método "listarLivrosNaoEmprestados" e obtém seu retorno
        List<Funcionario> funcionariosCadastrados = funcionarioRepository.listar();
        if (funcionariosCadastrados.isEmpty()) {
            System.out.println("Não há funcionários cadastrados no momento.");
        } else {
            System.out.println("Funcionários cadastrados:");
            for (Funcionario funcionario : funcionariosCadastrados) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("Superior: " + funcionario.getSuperior());
                System.out.println("--------------------------------------");
            }
        }
    }

    @Override
    public void atualizar(String funcionarioAtualizar, String nome, String cargo, String telefone, String email, double salario, String superior) {
        Funcionario novoDadoFuncionario = new Funcionario(nome, cargo, telefone, email, salario, superior);
        funcionarioRepository.atualizar(novoDadoFuncionario, funcionarioAtualizar);
    }

    @Override
    public void deletar(String funcionarioExcluir) {
        funcionarioRepository.deletar(funcionarioExcluir);
    }


}
