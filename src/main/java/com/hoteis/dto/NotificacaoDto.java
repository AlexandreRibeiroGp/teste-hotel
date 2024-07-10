package com.hoteis.dto;

import com.hoteis.model.Reserva;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificacaoDto {
    private Reserva reservaId;
    private String message;
    private String status;
    private LocalDateTime dataEnvio;
}
