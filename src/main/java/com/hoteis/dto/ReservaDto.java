package com.hoteis.dto;

import com.hoteis.model.Hotel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaDto {
    private Hotel hotelId;
    private UsuarioDto usuario;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numeroQuartos;
    private int numeroHospedes;
    private String status;
    private Long pagamento_id;
}
