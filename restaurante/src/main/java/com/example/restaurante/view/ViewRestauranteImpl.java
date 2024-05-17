package com.example.restaurante.view;

public class ViewRestauranteImpl implements ViewRestaurante{

    @Override
    public void exibirMenu() {
        System.out.println("--------------- Menu ----------------");
        System.out.println("1. Gerenciamento de Clientes");
        System.out.println("-------------------------------------");
        System.out.println("2. Gerenciamento de Funcionários");
        System.out.println("-------------------------------------");
        System.out.println("3. Gerenciamento de Pedidos");
        System.out.println("-------------------------------------");
        System.out.println("4. Gerenciamento de Itens do Pedido");
        System.out.println("-------------------------------------");
        System.out.println("5. Gerenciamento de Pratos");
        System.out.println("-------------------------------------");
        System.out.println("6. Sair do Sistema");
        System.out.println("-------------------------------------");
    }
}
