package com.hoteis.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
