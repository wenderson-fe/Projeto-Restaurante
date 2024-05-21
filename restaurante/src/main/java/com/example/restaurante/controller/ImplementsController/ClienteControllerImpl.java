package com.example.restaurante.controller.ImplementsController;

import com.example.restaurante.controller.InterfacesController.ClienteController;
import com.example.restaurante.model.repository.InterfacesRepository.ClienteRepository;

public class ClienteControllerImpl implements ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteControllerImpl (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

}
