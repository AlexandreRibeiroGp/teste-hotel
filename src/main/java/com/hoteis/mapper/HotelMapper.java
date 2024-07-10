package com.hoteis.mapper;
import com.hoteis.dto.HotelDto;
import com.hoteis.model.Hotel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface HotelMapper {

    public static final HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "localizacao", target = "localizacao")
    @Mapping(source = "precoPorNoite", target = "precoPorNoite")
    @Mapping(source = "comodidades", target = "comodidades")
    @Mapping(source = "avaliacoes", target = "avaliacoes")
    @Mapping(source = "numeroQuartosDisponiveis", target = "numeroQuartosDisponiveis")
    @Mapping(source = "numeroHospedes", target = "numeroHospedes")
    @Mapping(source = "checkInDate", target = "checkInDate")
    @Mapping(source = "checkOutDate", target = "checkOutDate")
    HotelDto toDto(Hotel hotel);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "localizacao", target = "localizacao")
    @Mapping(source = "precoPorNoite", target = "precoPorNoite")
    @Mapping(source = "comodidades", target = "comodidades")
    @Mapping(source = "avaliacoes", target = "avaliacoes")
    @Mapping(source = "numeroQuartosDisponiveis", target = "numeroQuartosDisponiveis")
    @Mapping(source = "numeroHospedes", target = "numeroHospedes")
    @Mapping(source = "checkInDate", target = "checkInDate")
    @Mapping(source = "checkOutDate", target = "checkOutDate")
    Hotel toEntity(HotelDto hotelDto);
}
