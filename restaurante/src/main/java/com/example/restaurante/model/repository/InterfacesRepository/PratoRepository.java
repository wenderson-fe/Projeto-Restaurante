package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.Cliente;
import com.example.restaurante.model.entity.Prato;

import java.util.List;

public interface PratoRepository {
    void cadastrarPrato(Prato prato);
    List<Prato> listarPrato();
    void atualizarPrato(Prato novoDadoPrato, String prato);
    void deletarPrato(String pratoExcluir);
}
