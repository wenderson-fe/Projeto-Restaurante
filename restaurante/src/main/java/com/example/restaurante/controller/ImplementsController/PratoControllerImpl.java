package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.PratoController;
import com.example.restaurante.model.entity.Cliente;
import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.entity.Prato;
import com.example.restaurante.model.repository.InterfacesRepository.PratoRepository;

import java.util.List;

public class PratoControllerImpl implements PratoController {
    private PratoRepository pratoRepository;

    public PratoControllerImpl(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @Override
    public void cadastrarPrato(String nome, String descricao, double preco) {
        // Criar objeto de prato com as informações recebidas
        Prato novoPrato = new Prato(nome, descricao, preco);

        // Adicionar o prato ao repositório
        pratoRepository.cadastrarPrato(novoPrato);
    }

    @Override
    public void atualizarPrato(String pratoAtualizar, String nome, String descricao, double preco) {
        Prato novoDadoPrato = new Prato(nome, descricao, preco);

        pratoRepository.atualizarPrato(novoDadoPrato, pratoAtualizar);
    }

    @Override
    public void deletarPrato(String pratoExcluir) {
        pratoRepository.deletarPrato(pratoExcluir);
    }

    @Override
    public void listarPrato() {
        //Chama o método "listarPrato" e obtém seu retorno
        List<Prato> pratosCadastrados = pratoRepository.listarPrato();
        if (pratosCadastrados.isEmpty()) {
            System.out.println("Não há pratos cadastrados no momento.");
        } else {
            System.out.println("Pratos cadastrados: ");
            for (Prato prato : pratosCadastrados) {
                System.out.println("Nome: " + prato.getNome());
                System.out.println("Descrição: " + prato.getDescricao());
                System.out.println("Preço: " + prato.getPreco());
                System.out.println("--------------------------------------");
            }
        }
    }
}
