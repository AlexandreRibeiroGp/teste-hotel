package com.hoteis.dto;

import com.hoteis.model.Avaliacao;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class HotelDto {

    private Long id;
    private String nome;
    private String localizacao;
    private BigDecimal precoPorNoite;
    private List<String> comodidades;
    private List<Avaliacao> avaliacoes;
    private Integer numeroQuartosDisponiveis;
    private Integer numeroHospedes;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}


