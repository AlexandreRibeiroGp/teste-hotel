package com.hoteis.model;

import lombok.Data;


import jakarta.persistence.*;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotelId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "numero_quartos")
    private Integer numeroQuartos;

    @Column(name = "numero_hospedes")
    private Integer numeroHospedes;

    @Column(name = "status")
    private String status;

    @Column(name = "pagamento_id")
    private Long pagamento_id;

}
