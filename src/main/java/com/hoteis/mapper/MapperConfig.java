package com.hoteis.mapper;

import com.hoteis.mapper.HotelMapper;
import com.hoteis.model.Reserva;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public HotelMapper hotelMappr() {
        return Mappers.getMapper(HotelMapper.class);
    }
    @Bean
    public UsuarioMapper usuarioMapper() {
        return UsuarioMapper.INSTANCE;
    }

    @Bean
    public ReservaMapper reservaMapper() {
        return ReservaMapper.INSTANCE;
    }

    @Bean
    public NotificacaoMapper notificacaoMapper() {
        return NotificacaoMapper.INSTANCE;
    }

    @Bean
    public PagamentoMapper pagamentoMapper() {
        return PagamentoMapper.INSTANCE;
    }
}