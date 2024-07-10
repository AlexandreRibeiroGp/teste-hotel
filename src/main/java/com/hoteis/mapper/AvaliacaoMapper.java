package com.hoteis.mapper;

import com.hoteis.dto.AvaliacaoDto;
import com.hoteis.model.Avaliacao;
import org.mapstruct.Mapper;

public class AvaliacaoMapper {

    public Avaliacao toEntity(AvaliacaoDto dto) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        return avaliacao;
    }

    public AvaliacaoDto toDTO(Avaliacao avaliacao) {
        AvaliacaoDto dto = new AvaliacaoDto();
        dto.setNota(avaliacao.getNota());
        dto.setComentario(avaliacao.getComentario());
        dto.setHotelId(avaliacao.getHotel());
        dto.setUsuarioId(avaliacao.getUsuario());
        return dto;
    }
}
