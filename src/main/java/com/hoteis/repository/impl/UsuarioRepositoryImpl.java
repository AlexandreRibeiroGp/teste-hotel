package com.hoteis.repository.impl;

import com.hoteis.model.Usuario;
import com.hoteis.model.Avaliacao;
import com.hoteis.repository.AvaliacaoRepository;
import com.hoteis.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario save(Usuario usuario) {
        if (usuario.getId() == null) {
            entityManager.persist(usuario);
        } else {
            entityManager.merge(usuario);
        }
        return usuario;
    }

    @Override
    public List<Usuario> findByNome(String nome) {
        String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome";
        return entityManager.createQuery(jpql, Usuario.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    @Override
    public List<Usuario> findByEmail(String email) {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email";
        return entityManager.createQuery(jpql, Usuario.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public List<Usuario> findByNomeAndEmail(String nome, String email) {
        String jpql = "SELECT u FROM Usuario u WHERE u.nome = :nome AND u.email = :email";
        return entityManager.createQuery(jpql, Usuario.class)
                .setParameter("nome", nome)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public List<Usuario> findAll() {
        String jpql = "SELECT u FROM Usuario u";
        return entityManager.createQuery(jpql, Usuario.class).getResultList();
    }
}