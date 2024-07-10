package com.hoteis.repository.impl;

import com.hoteis.model.Notificacao;
import com.hoteis.model.Avaliacao;
import com.hoteis.repository.AvaliacaoRepository;
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
public class NotificacaoRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Notificacao> findByReservaId(Long reservaId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notificacao> query = cb.createQuery(Notificacao.class);
        Root<Notificacao> notificacao = query.from(Notificacao.class);

        Predicate reservaPredicate = cb.equal(notificacao.get("reservaId"), reservaId);
        query.where(reservaPredicate);

        return entityManager.createQuery(query).getResultList();
    }
}
