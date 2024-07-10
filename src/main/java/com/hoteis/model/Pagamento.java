package com.hoteis.model;


import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metodo_pagamento", nullable = false)
    private String metodoPagamento;

    @Column(name = "valor_pago", nullable = false)
    private Double valorPago;

    @Column(name = "status_pagamento", nullable = false)
    private String statusPagamento;

    // Outros campos e métodos, se necessário
}