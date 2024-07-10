package com.hoteis.model;

import lombok.Data;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "notificacoes")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reservaId;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio;

}
