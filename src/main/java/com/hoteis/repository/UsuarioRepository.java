package com.hoteis.repository;

import com.hoteis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    List<Usuario> findByNome(String nome);
    List<Usuario> findByEmail(String email);
    List<Usuario> findByNomeAndEmail(String nome, String email);
    List<Usuario> findAll();
}