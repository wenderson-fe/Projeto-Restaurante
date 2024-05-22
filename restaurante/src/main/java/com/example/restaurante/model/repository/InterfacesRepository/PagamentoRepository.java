package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.Pagamento;
import com.example.restaurante.model.entity.Prato;

import java.util.List;

public interface PagamentoRepository {
    void cadastrarFormaPagamento(Pagamento pagamento);
    List<Pagamento> listarFormaPagamento();
    void atualizarFormaPagamento(Pagamento novoDadoPagamento, String pagamento);
    void deletarFormaPagamento(String pagamentoExcluir);
}
