package com.hoteis.service;

import com.hoteis.dto.AvaliacaoDto;
import com.hoteis.model.Avaliacao;

import java.util.List;

public interface AvaliacaoService {
    List<Avaliacao> getAvaliacoesByHotelAndUsuario(Long hotelId, Long usuarioId);
    Avaliacao submitAvaliacao(AvaliacaoDto avaliacaoDTO);
}