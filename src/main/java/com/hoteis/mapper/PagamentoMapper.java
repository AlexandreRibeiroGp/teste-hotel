package com.hoteis.mapper;

import com.hoteis.dto.NotificacaoDto;
import com.hoteis.dto.PagamentoDto;
import com.hoteis.model.Notificacao;
import com.hoteis.model.Pagamento;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true))
public interface PagamentoMapper {

    public static final PagamentoMapper INSTANCE = Mappers.getMapper(PagamentoMapper.class);

    PagamentoDto toDto(Pagamento pagamento);

    Pagamento toEntity(PagamentoDto pagamentoDto);
}
