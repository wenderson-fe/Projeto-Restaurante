package com.example.restaurante.controller;

import com.example.restaurante.model.entity.Funcionario;
import com.example.restaurante.model.repository.RepositorioRestaurante;

public class ControllerRestauranteImpl implements ControllerRestaurante{
    private RepositorioRestaurante repositorioRestaurante;

    public ControllerRestauranteImpl(RepositorioRestaurante repositorioRestaurante) {
        this.repositorioRestaurante = repositorioRestaurante;
    }

    @Override
    public void cadastrar(String nome, String cargo, String telefone, String email, double salario, String superior) {
        // Criar objeto do funcionário com as informações recebidas
        Funcionario novoFuncionario = new Funcionario(nome, cargo, telefone, email, salario, superior);

        // Adicionar o funcionario ao repositório
        repositorioRestaurante.cadastrar(novoFuncionario);

    }
}
