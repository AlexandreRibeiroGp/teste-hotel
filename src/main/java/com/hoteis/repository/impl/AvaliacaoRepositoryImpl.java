package com.hoteis.repository.impl;

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

public class AvaliacaoRepositoryImpl  {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Avaliacao> findByHotelIdAndUsuarioId(Long hotelId, Long usuarioId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Avaliacao> query = cb.createQuery(Avaliacao.class);
        Root<Avaliacao> avaliacao = query.from(Avaliacao.class);

        List<Predicate> predicates = new ArrayList<>();
        if (hotelId != null) {
            predicates.add(cb.equal(avaliacao.get("hotelId"), hotelId));
        }
        if (usuarioId != null) {
            predicates.add(cb.equal(avaliacao.get("usuarioId"), usuarioId));
        }

        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
