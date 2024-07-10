package com.hoteis.mapper;
import com.hoteis.dto.ReservaDto;
import com.hoteis.model.Reserva;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true))
public interface ReservaMapper {

    public static final ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    @Mappings({
            @Mapping(target = "usuario", source = "usuario"),
            @Mapping(target = "hotelId", source = "hotelId"),
            @Mapping(target = "pagamento_id", source = "pagamento_id"),

    })
    ReservaDto toDto(Reserva reserva);

     Reserva toEntity(ReservaDto reservaDto);
}