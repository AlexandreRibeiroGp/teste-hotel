package com.hoteis.service;

import com.hoteis.dto.ReservaDto;
import com.hoteis.model.*;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;




@Service
public interface ReservaService {


    List<Reserva> listarTodas();

    Reserva buscarPorId(Long id);

    ReservaDto criarReserva(ReservaDto reservaDto);

    Reserva atualizarReserva(Long id, Reserva reserva);

    void deletarReserva(Long id);

    List<Reserva> findReservasByCriteria(Long hotelId, LocalDate checkInDate, LocalDate checkOutDate, Long usuarioId);

}