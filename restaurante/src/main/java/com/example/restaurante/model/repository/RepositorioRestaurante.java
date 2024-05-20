package com.example.restaurante.model.repository;

import com.example.restaurante.model.entity.Funcionario;

import java.util.List;

public interface RepositorioRestaurante {
    void cadastrar(Funcionario novoFuncionario);
    List<Funcionario> listar();
    void atualizar(Funcionario novoDadoFuncionario, String funcionario);
    void deletar(String funcionarioExcluir);

}
