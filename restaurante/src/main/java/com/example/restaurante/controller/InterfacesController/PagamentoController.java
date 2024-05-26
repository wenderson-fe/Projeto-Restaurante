package com.example.restaurante.controller.InterfacesController;

public interface PagamentoController {
    void cadastrarFormaPagamento(String nome, String taxa);
    void listarFormaPagamento();
    void atualizarFormaPagamento(String pagamentoAtualizar, String nome, String taxa);
    void deletarFormaPagamento(String pagamentoExcluir);
}
