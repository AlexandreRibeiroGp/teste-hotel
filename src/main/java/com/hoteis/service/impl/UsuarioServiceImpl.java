package com.hoteis.service.impl;

import com.hoteis.dto.UsuarioDto;
import com.hoteis.mapper.UsuarioMapper;
import com.hoteis.model.Usuario;
import com.hoteis.repository.UsuarioRepository;
import com.hoteis.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioServiceImpl  implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioDto> pesquisarUsuarios(String nome, String email) {
        List<Usuario> usuarios;

        if (nome != null && email != null) {
            usuarios = usuarioRepository.findByNomeAndEmail(nome, email);
        } else if (nome != null) {
            usuarios = usuarioRepository.findByNome(nome);
        } else if (email != null) {
            usuarios = usuarioRepository.findByEmail(email);
        } else {
            usuarios = usuarioRepository.findAll();
        }

        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}