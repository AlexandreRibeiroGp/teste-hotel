package com.hoteis.service.impl;

import com.hoteis.dto.PagamentoDto;
import com.hoteis.dto.ReservaDto;
import com.hoteis.mapper.PagamentoMapper;
import com.hoteis.mapper.ReservaMapper;
import com.hoteis.model.*;
import com.hoteis.repository.ReservaRepository;
import com.hoteis.repository.impl.PagamentoRepositoryImpl;
import com.hoteis.repository.impl.ReservaRepositoryImpl;
import com.hoteis.service.NotificacaoService;
import com.hoteis.service.PagamentoService;
import com.hoteis.service.ReservaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    @PersistenceContext
    private EntityManager entityManager;


    private final PagamentoMapper pagamentoMapper;

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final NotificacaoService notificationService;

    private final PagamentoRepositoryImpl pagamentoRepositoryImpl;
    private final PagamentoService pagamentoService;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository, ReservaMapper reservaMapper, PagamentoService pagamentoService, PagamentoRepositoryImpl pagamentoRepositoryImpl,
                              PagamentoMapper pagamentoMapper, NotificacaoService notificationService) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.pagamentoService = pagamentoService;
        this.pagamentoRepositoryImpl = pagamentoRepositoryImpl;
        this.pagamentoMapper = pagamentoMapper;
        this.notificationService = notificationService;
    }


    @Override
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return null;
    }

    @Transactional
    @Override
    public ReservaDto criarReserva(ReservaDto reservaDto) {

        Reserva reserva = reservaMapper.toEntity(reservaDto);
        reserva = reservaRepository.save(reserva);
        String message = "Reserva criada: " + reserva.getId();
        notificationService.sendKafkaMessage(message);
        notificationService.sendEmail(reserva.getUsuario().getEmail(), "Confirmação de Reserva", "Sua reserva foi confirmada. " + reserva.getId());
        return reservaMapper.toDto(reserva);
    }
    @Override
    public Reserva atualizarReserva(Long id, Reserva reserva) {
        reserva.setId(id);
        return reservaRepository.save(reserva);
    }

    @Override
    public void deletarReserva(Long id) {

    }


    @Override
    public List<Reserva> findReservasByCriteria(Long hotelId, LocalDate checkInDate, LocalDate checkOutDate, Long usuarioId) {
        return null;
    }
}