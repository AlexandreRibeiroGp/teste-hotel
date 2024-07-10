package com.hoteis.mapper;

import com.hoteis.dto.NotificacaoDto;
import com.hoteis.dto.ReservaDto;
import com.hoteis.model.Notificacao;
import com.hoteis.model.Reserva;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface NotificacaoMapper  {

    public static final NotificacaoMapper INSTANCE = Mappers.getMapper(NotificacaoMapper.class);

    NotificacaoDto toDto(Notificacao notificacao);

    Notificacao toEntity(NotificacaoDto notificacaoDto);
}