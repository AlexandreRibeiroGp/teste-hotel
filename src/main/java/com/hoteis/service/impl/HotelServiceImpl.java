package com.hoteis.service.impl;

import com.hoteis.model.Hotel;
import com.hoteis.repository.HotelRepository;
import com.hoteis.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel criarHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel obterHotelPorId(Long id) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        return hotelOpt.orElse(null);
    }

    @Override
    public Hotel atualizarHotel(Long id, Hotel hotel) {
        if (hotelRepository.existsById(id)) {
            hotel.setId(id);
            return hotelRepository.save(hotel);
        } else {
            return null; // ou lance uma exceção se preferir
        }
    }

    @Override
    public void deletarHotel(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
        } else {
            // lance uma exceção se preferir
        }
    }

    public List<Hotel> compararHoteis(String localizacao, BigDecimal precoMaximo, List<String> comodidades, Double avaliacaoMinima) {

        List<Hotel> hoteis = hotelRepository.findByLocalizacaoAndPrecoAndComodidadesAndAvaliacao(localizacao, precoMaximo, comodidades, avaliacaoMinima);

        return hoteis;
    }
    @Override
    public List<Hotel> pesquisarHoteis(String destino, LocalDate checkInDate, LocalDate checkOutDate, Integer numeroQuartos, Integer numeroHospedes) {
        return hotelRepository.findByDestinoAndDatasAndQuartosEHospedes(destino, checkInDate, checkOutDate, numeroQuartos, numeroHospedes);
    }
}