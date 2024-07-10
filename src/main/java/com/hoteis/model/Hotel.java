package com.hoteis.model;

import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "hotels")
public class Hotel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "localizacao", nullable = false)
    private String localizacao;

    @Column(name = "preco_por_noite", nullable = false)
    private BigDecimal precoPorNoite;

    @ElementCollection
    @CollectionTable(name = "hotel_comodidades", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "comodidade")
    private List<String> comodidades;

    @OneToMany(mappedBy = "hotel")
    private List<Avaliacao> avaliacoes;

    @Column(name = "numero_quartos_disponiveis", nullable = false)
    private Integer numeroQuartosDisponiveis;

    @Column(name = "numero_hospedes", nullable = false)
    private Integer numeroHospedes;

    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;


}