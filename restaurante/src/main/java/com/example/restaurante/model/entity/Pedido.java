package com.example.restaurante.model.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Pedido {
    private Date data;
    private Time hora;
    private String status;
    private String funcionario;
    private String cliente;
    private String formaDePagamento;

    public Pedido(String funcionario, String cliente, String formaDePagamento) {
        this.data = java.sql.Date.valueOf(LocalDate.now());
        this.hora = java.sql.Time.valueOf(LocalTime.now());
        this.status =  "Criado";
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.formaDePagamento = formaDePagamento;
    }

    public Date getData() {
        return data;
    }

    public Time getHora() {
        return hora;
    }

    public String getStatus() {
        return status;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

}
