package com.example.restaurante;

import com.example.restaurante.controller.ControllerRestauranteImpl;
import com.example.restaurante.model.repository.RepositorioRestaurante;
import com.example.restaurante.model.repository.RepositorioRestauranteImpl;
import com.example.restaurante.view.ViewRestaurante;
import com.example.restaurante.view.ViewRestauranteImpl;
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
		RepositorioRestaurante repositorioRestaurante = new RepositorioRestauranteImpl();
		ControllerRestauranteImpl controllerRestaurante = new ControllerRestauranteImpl(repositorioRestaurante);
		ViewRestaurante view = new ViewRestauranteImpl(controllerRestaurante);

		do {
			view.exibirMenu();
			System.out.println("Escolha: ");

			// Verifica se a entrada é um número
			if (sc.hasNextInt()) {
				int escolha = sc.nextInt();
				sc.nextLine(); // Limpa o buffer

				view.executarOpcao(escolha);

			} else {
				System.out.println("Entrada inválida! Por favor, digite um número.");
				sc.nextLine(); // Limpa o buffer
			}

		} while (continuar); // O sistema só é encerrado com a interação do usuário

		sc.close();


	}
}
