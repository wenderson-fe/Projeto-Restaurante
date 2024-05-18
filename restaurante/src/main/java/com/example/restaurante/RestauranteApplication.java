package com.example.restaurante;

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

		ViewRestaurante view = new ViewRestauranteImpl();
		do {
			view.exibirMenu();
			System.out.println("Escolha: ");

			// Verifica se a entrada é um número
			if (sc.hasNextInt()) {
				int escolha = sc.nextInt();
				sc.nextLine(); // Limpa o buffer

				view.executarOpcao(escolha);

				continuar = !view.saindoDoSistema(); //operador "!" para inverter o valor retornado pelo método saindoDoSistema
			} else {
				System.out.println("Entrada inválida! Por favor, digite um número.");
				sc.nextLine(); // Limpa o buffer
			}
		} while (continuar);

		sc.close();


	}
}
