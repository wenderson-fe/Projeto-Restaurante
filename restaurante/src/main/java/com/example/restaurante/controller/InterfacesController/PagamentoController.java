package com.example.restaurante.controller.InterfacesController;

import com.example.restaurante.model.entity.Pagamento;

import java.util.List;

public interface PagamentoController {
    void cadastrarFormaPagamento(String descricao, String taxa);
    void listarFormaPagamento();
    void atualizarFormaPagamento(String pagamentoAtualizar, String descricao, String taxa);
    void deletarFormaPagamento(String pagamentoExcluir);
}
