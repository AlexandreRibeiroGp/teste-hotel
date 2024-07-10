package com.hoteis.dto;

import com.hoteis.model.Hotel;
import com.hoteis.model.Usuario;
import lombok.Data;


@Data
public class AvaliacaoDto {
    private Hotel hotelId;
    private Usuario usuarioId;
    private int nota;
    private String comentario;
}
