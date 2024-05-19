package com.example.restaurante.controller;

import com.example.restaurante.model.repository.RepositorioRestaurante;

public class ControllerRestauranteImpl implements ControllerRestaurante{
    private RepositorioRestaurante repositorioRestaurante;

    public ControllerRestauranteImpl(RepositorioRestaurante repositorioRestaurante) {
        this.repositorioRestaurante = repositorioRestaurante;
    }

    @Override
    public void cadastrarFuncionario() {

    }
}
