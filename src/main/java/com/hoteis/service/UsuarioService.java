package com.hoteis.service;

import com.hoteis.dto.UsuarioDto;
import com.hoteis.model.Usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto);
    List<UsuarioDto> pesquisarUsuarios(String nome, String email);
}