package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.PagamentoController;
import com.example.restaurante.model.entity.Pagamento;
import com.example.restaurante.model.repository.InterfacesRepository.PagamentoRepository;

import java.util.List;

public class PagamentoControllerImpl implements PagamentoController {
    private PagamentoRepository pagamentoRepository;

    public PagamentoControllerImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public void cadastrarFormaPagamento(String nome, String taxa) {
        // Criar objeto de pagamento com as informações recebidas
        Pagamento novaFormaDePagamento = new Pagamento(nome, taxa);

        // Adicionar a forma de pagamento ao repositório
        pagamentoRepository.cadastrarFormaPagamento(novaFormaDePagamento);
    }

    @Override
    public void listarFormaPagamento() {
        //Chama o método "listarFormaPagamento" e obtém seu retorno
        List<Pagamento> formasDePagamento = pagamentoRepository.listarFormaPagamento();
        if (formasDePagamento.isEmpty()) {
            System.out.println("Não há formas de pagamento cadastrados no momento.");
        } else {
            System.out.println("Formas de pagamento cadastradas: ");
            for (Pagamento pagamento : formasDePagamento) {
                System.out.println("Nome: " + pagamento.getNome());
                System.out.println("Taxa: " + pagamento.getTaxa());
                System.out.println("--------------------------------------");
            }
        }
    }

    @Override
    public void atualizarFormaPagamento(String pagamentoAtualizar, String nome, String taxa) {
        Pagamento novoDadoPagamento = new Pagamento(nome, taxa);

        pagamentoRepository.atualizarFormaPagamento(novoDadoPagamento, pagamentoAtualizar);
    }

    @Override
    public void deletarFormaPagamento(String pagamentoExcluir) {
        pagamentoRepository.deletarFormaPagamento(pagamentoExcluir);
    }
}
