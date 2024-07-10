package com.hoteis;

import com.hoteis.dto.ReservaDto;
import com.hoteis.model.Reserva;
import com.hoteis.service.ReservaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.when;

class ReservaServiceTest {

    @Test
    void testListarTodas() {
        ReservaService reservaService = Mockito.mock(ReservaService.class);
        List<Reserva> reservas = List.of(new Reserva(), new Reserva());
        when(reservaService.listarTodas()).thenReturn(reservas);

        List<Reserva> result = reservaService.listarTodas();
        reservas(2, result.size());
    }

    private void reservas(int i, int size) {
    }

    @Test
    void testBuscarPorId() {
        ReservaService reservaService = Mockito.mock(ReservaService.class);
        Reserva reserva = new Reserva();
        when(reservaService.buscarPorId(1L)).thenReturn(reserva);

        Reserva result = reservaService.buscarPorId(1L);
        assertNotNull(result);
    }

    @Test
    void testCriarReserva() {
        ReservaService reservaService = Mockito.mock(ReservaService.class);
        ReservaDto reservaDto = new ReservaDto();
        when(reservaService.criarReserva(reservaDto)).thenReturn(reservaDto);

        ReservaDto result = reservaService.criarReserva(reservaDto);
        assertNotNull(result);
    }
}