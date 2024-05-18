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

		//Scanner sc = new Scanner(System.in);

		//ViewRestaurante view = new ViewRestauranteImpl();

		//view.exibirMenu();

	}
}
