package com.example.restaurante.model.repository.InterfacesRepository;

import com.example.restaurante.model.entity.Funcionario;

import java.util.List;

public interface FuncionarioRepository {
    void cadastrarFuncionario(Funcionario novoFuncionario);
    List<Funcionario> listarFuncionario();
    void atualizarFuncionario(Funcionario novoDadoFuncionario, String funcionario);
    void deletarFuncionario(String funcionarioExcluir);

}
