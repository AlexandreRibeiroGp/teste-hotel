package com.hoteis.controller;

import com.hoteis.dto.ReservaDto;
import com.hoteis.mapper.ReservaMapper;
import com.hoteis.model.Reserva;
import com.hoteis.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ReservaMapper reservaMapper;

    @Autowired
    public ReservaController(ReservaService reservaService, ReservaMapper reservaMapper) {
        this.reservaService = reservaService;
        this.reservaMapper = reservaMapper;
    }

    @GetMapping
    public ResponseEntity<List<ReservaDto>> listarTodasReservas() {
        List<Reserva> reservas = reservaService.listarTodas();
        List<ReservaDto> reservaDtos = reservas.stream()
                .map(reservaMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(reservaDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> buscarReservaPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarPorId(id);
        if (reserva != null) {
            return new ResponseEntity<>(reservaMapper.toDto(reserva), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ReservaDto> criarReserva(@RequestBody ReservaDto reservaDto) {
        this.reservaService.criarReserva(reservaDto);
        return new ResponseEntity<>(reservaDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> atualizarReserva(@PathVariable Long id, @RequestBody ReservaDto reservaDto) {
        Reserva reserva = reservaMapper.toEntity(reservaDto);
        Reserva reservaAtualizada = reservaService.atualizarReserva(id, reserva);
        if (reservaAtualizada != null) {
            return new ResponseEntity<>(reservaMapper.toDto(reservaAtualizada), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}