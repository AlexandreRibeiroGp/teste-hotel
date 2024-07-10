package com.hoteis.dto;


import lombok.Data;

@Data
public class PagamentoDto {
    private Long id;
    private String metodoPagamento;
    private double valorPago;
    private String statusPagamento;
}