package com.example.restaurante.model.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class PedidoCadastrado {
    private int id;
    private Date data;
    private Time hora;
    private String status;
    private double valorTotal;
    private String nomeFuncionario;
    private String nomeCliente;
    private String nomeFormaDePagamento;
    private int quantidade;
    private List<ItemPedido> itensPedido;

    public PedidoCadastrado(int id, Date data, Time hora, String status, double valorTotal, String nomeFuncionario, String nomeCliente, String nomeFormaDePagamento, int quantidade) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.valorTotal = valorTotal;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeCliente = nomeCliente;
        this.nomeFormaDePagamento = nomeFormaDePagamento;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public Date getDataCadastrado() {
        return data;
    }

    public Time getHoraCadastrado() {
        return hora;
    }

    public String getStatusCadastrado() {
        return status;
    }

    public double getValorTotalCadastrado() {
        return valorTotal;
    }

    public String getNomeFuncionarioCadastrado() {
        return nomeFuncionario;
    }

    public String getNomeClienteCadastrado() {
        return nomeCliente;
    }

    public String getNomeFormaDePagamentoCadastrado() {
        return nomeFormaDePagamento;
    }

    public int getQuantidadeCadastrado() {
        return quantidade;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

}
