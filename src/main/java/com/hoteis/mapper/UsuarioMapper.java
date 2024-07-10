package com.hoteis.mapper;

import com.hoteis.dto.UsuarioDto;
import com.hoteis.model.Usuario;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UsuarioMapper {

        public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

        UsuarioDto toDto(Usuario usuario);

        Usuario toEntity(UsuarioDto usuarioDto);
}