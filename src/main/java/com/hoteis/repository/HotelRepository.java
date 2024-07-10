package com.hoteis.repository;

import com.hoteis.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

        List<Hotel> findByDestinoAndDatasAndQuartosEHospedes(String destino, LocalDate checkInDate, LocalDate checkOutDate, Integer numeroQuartos, Integer numeroHospedes);

        List<Hotel> findByLocalizacaoAndPrecoAndComodidadesAndAvaliacao(String localizacao, BigDecimal precoMaximo, List<String> comodidades, Double avaliacaoMinima);

}
