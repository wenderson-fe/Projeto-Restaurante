package com.example.restaurante;

import com.example.restaurante.controller.ImplementsController.ClienteControllerImpl;
import com.example.restaurante.controller.InterfacesController.ClienteController;
import com.example.restaurante.controller.InterfacesController.FuncionarioController;
import com.example.restaurante.controller.ImplementsController.FuncionarioControllerImpl;
import com.example.restaurante.model.repository.ImplementsRepository.ClienteRepositoryImpl;
import com.example.restaurante.model.repository.InterfacesRepository.ClienteRepository;
import com.example.restaurante.model.repository.InterfacesRepository.FuncionarioRepository;
import com.example.restaurante.model.repository.ImplementsRepository.FuncionarioRepositoryImpl;
import com.example.restaurante.view.ImplementsView.ClienteViewImpl;
import com.example.restaurante.view.InterfacesView.ClienteView;
import com.example.restaurante.view.InterfacesView.FuncionarioView;
import com.example.restaurante.view.ImplementsView.FuncionarioViewImpl;
import com.example.restaurante.view.InterfacesView.InterfaceView;
import com.example.restaurante.view.ImplementsView.InterfaceViewImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);

		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		// Configuração das dependências
		FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryImpl();
		ClienteRepository clienteRepository = new ClienteRepositoryImpl();

		FuncionarioController funcionarioController = new FuncionarioControllerImpl(funcionarioRepository);
		ClienteController clienteController = new ClienteControllerImpl(clienteRepository);

		FuncionarioView funcionarioView = new FuncionarioViewImpl(funcionarioController);
		ClienteView clienteView = new ClienteViewImpl(clienteController);
		InterfaceView interfaceView = new InterfaceViewImpl(funcionarioView, clienteView);

		do {
			interfaceView.exibirMenu();
			System.out.println("Escolha: ");

			// Verifica se a entrada é um número
			if (sc.hasNextInt()) {
				int escolha = sc.nextInt();
				sc.nextLine(); // Limpa o buffer

				interfaceView.executarOpcao(escolha);

			} else {
				System.out.println("Entrada inválida! Por favor, digite um número.");
				sc.nextLine(); // Limpa o buffer
			}

		} while (continuar); // O sistema só é encerrado com a interação do usuário

		sc.close();


	}
}
