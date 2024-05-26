package com.example.restaurante;

import com.example.restaurante.controller.ImplementsController.*;
import com.example.restaurante.controller.InterfacesController.*;
import com.example.restaurante.model.repository.ImplementsRepository.*;
import com.example.restaurante.model.repository.InterfacesRepository.*;
import com.example.restaurante.view.ImplementsView.*;
import com.example.restaurante.view.InterfacesView.*;
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
		PratoRepository pratoRepository = new PratoRepositoryImpl();
		PagamentoRepository pagamentoRepository = new PagamentoRepositoryImpl();

		ItemPedidoRepository itemPedidoRepository = new ItemPedidoRepositoryImpl();
		PedidoRepository pedidoRepository = new PedidoRepositoryImpl(itemPedidoRepository);

		FuncionarioController funcionarioController = new FuncionarioControllerImpl(funcionarioRepository);
		ClienteController clienteController = new ClienteControllerImpl(clienteRepository);
		PratoController pratoController = new PratoControllerImpl(pratoRepository);
		PagamentoController pagamentoController = new PagamentoControllerImpl(pagamentoRepository);
		PedidoController pedidoController = new PedidoControllerImpl(pedidoRepository);
		ItemPedidoController itemPedidoController = new ItemPedidoControllerImpl(itemPedidoRepository);

		FuncionarioView funcionarioView = new FuncionarioViewImpl(funcionarioController);
		ClienteView clienteView = new ClienteViewImpl(clienteController);
		PratoView pratoView = new PratoViewImpl(pratoController);
		PagamentoView pagamentoView = new PagamentoViewImpl(pagamentoController);
		PedidoView pedidoView = new PedidoViewImpl(pedidoController);
		ItemPedidoView itemPedidoView = new ItemPedidoViewImpl(itemPedidoController);

		InterfaceView interfaceView = new InterfaceViewImpl(funcionarioView, clienteView, pratoView, pagamentoView,
		pedidoView, itemPedidoView);

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
