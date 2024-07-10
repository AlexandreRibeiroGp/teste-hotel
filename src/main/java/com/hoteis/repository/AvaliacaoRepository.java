package com.hoteis.repository;

import com.hoteis.model.Avaliacao;
import com.hoteis.model.Hotel;
import com.hoteis.repository.impl.AvaliacaoRepositoryImpl;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByHotelIdAndUsuarioId(Long hotelId, Long usuarioId);
}