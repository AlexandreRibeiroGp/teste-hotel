package com.hoteis.controller;


import com.hoteis.dto.UsuarioDto;
import com.hoteis.model.Usuario;
import com.hoteis.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping()
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto novoUsuario = usuarioService.cadastrarUsuario(usuarioDto);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> pesquisarUsuarios(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email) {
        List<UsuarioDto> usuarios = usuarioService.pesquisarUsuarios(nome, email);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}