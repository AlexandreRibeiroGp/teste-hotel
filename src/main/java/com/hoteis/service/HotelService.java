package com.hoteis.service;

import com.hoteis.model.Hotel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface HotelService {
    Hotel criarHotel(Hotel hotel);
    Hotel obterHotelPorId(Long id);
    Hotel atualizarHotel(Long id, Hotel hotel);
    void deletarHotel(Long id);



    public List<Hotel> compararHoteis(String localizacao, BigDecimal precoMaximo, List<String> comodidades, Double avaliacaoMinima) ;


    List<Hotel> pesquisarHoteis(String destino, LocalDate checkInDate, LocalDate checkOutDate, Integer numeroQuartos, Integer numeroHospedes);
}