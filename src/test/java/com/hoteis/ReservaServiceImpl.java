package com.hoteis;

import com.hoteis.dto.ReservaDto;
import com.hoteis.mapper.ReservaMapper;
import com.hoteis.model.Reserva;
import com.hoteis.repository.ReservaRepository;
import com.hoteis.service.PagamentoService;
import com.hoteis.service.impl.ReservaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ReservaServiceImplTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private ReservaMapper reservaMapper;

    @Mock
    private PagamentoService pagamentoService;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    public ReservaServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodas() {
        List<Reserva> reservas = List.of(new Reserva(), new Reserva());
        when(reservaRepository.findAll()).thenReturn(reservas);

        List<Reserva> result = reservaService.listarTodas();
        assertEquals(2, result.size());
    }

    @Test
    void testBuscarPorId() {
        Reserva reserva = new Reserva();
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        Reserva result = reservaService.buscarPorId(1L);
        assertNotNull(result);
    }

    @Test
    void testCriarReserva() {
        ReservaDto reservaDto = new ReservaDto();
        Reserva reserva = new Reserva();
        when(reservaMapper.toEntity(reservaDto)).thenReturn(reserva);
        when(reservaRepository.save(reserva)).thenReturn(reserva);
        when(reservaMapper.toDto(reserva)).thenReturn(reservaDto);
        ReservaDto result = reservaService.criarReserva(reservaDto);
        assertNotNull(result);
    }
}