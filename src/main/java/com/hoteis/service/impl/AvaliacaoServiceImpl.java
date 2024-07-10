package com.hoteis.service.impl;

import com.hoteis.dto.AvaliacaoDto;
import com.hoteis.model.Avaliacao;
import com.hoteis.repository.AvaliacaoRepository;
import com.hoteis.service.AvaliacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<Avaliacao> getAvaliacoesByHotelAndUsuario(Long hotelId, Long usuarioId) {
        return avaliacaoRepository.findByHotelIdAndUsuarioId(hotelId, usuarioId);
    }

    @Override
    public Avaliacao submitAvaliacao(AvaliacaoDto avaliacaoDTO) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setHotel(avaliacaoDTO.getHotelId());
        avaliacao.setUsuario(avaliacaoDTO.getUsuarioId());
        avaliacao.setNota(avaliacaoDTO.getNota());
        avaliacao.setComentario(avaliacaoDTO.getComentario());
        return avaliacaoRepository.save(avaliacao);
    }
}
