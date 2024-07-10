package com.hoteis.repository.impl;

import com.hoteis.model.Hotel;
import com.hoteis.repository.HotelRepository;
import com.hoteis.model.Avaliacao;
import com.hoteis.repository.AvaliacaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hotel> findByDestinoAndDatasAndQuartosEHospedes(String destino, LocalDate checkInDate, LocalDate checkOutDate, Integer numeroQuartos, Integer numeroHospedes) {
        String jpql = "SELECT h FROM Hotel h WHERE h.localizacao = :destino ";

        if (checkInDate != null && checkOutDate != null) {
            jpql += "AND (h.checkInDate <= :checkInDate AND h.checkOutDate >= :checkOutDate) ";
        }

        if (numeroQuartos != null) {
            jpql += "AND h.numeroQuartosDisponiveis >= :numeroQuartos ";
        }

        if (numeroHospedes != null) {
            jpql += "AND h.numeroHospedes >= :numeroHospedes ";
        }

        TypedQuery<Hotel> query = entityManager.createQuery(jpql, Hotel.class);
        query.setParameter("destino", destino);

        if (checkInDate != null && checkOutDate != null) {
            query.setParameter("checkInDate", checkInDate);
            query.setParameter("checkOutDate", checkOutDate);
        }

        if (numeroQuartos != null) {
            query.setParameter("numeroQuartos", numeroQuartos);
        }

        if (numeroHospedes != null) {
            query.setParameter("numeroHospedes", numeroHospedes);
        }

        return query.getResultList();
    }

    public List<Hotel> findByLocalizacaoAndPrecoAndComodidadesAndAvaliacao(String localizacao, BigDecimal precoMaximo, List<String> comodidades, Double avaliacaoMinima) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> query = cb.createQuery(Hotel.class);
        Root<Hotel> hotel = query.from(Hotel.class);

        Predicate predicate = cb.conjunction();

        if (localizacao != null) {
            predicate = cb.and(predicate, cb.equal(hotel.get("localizacao"), localizacao));
        }

        if (precoMaximo != null) {
            predicate = cb.and(predicate, cb.lessThanOrEqualTo(hotel.get("precoPorNoite"), precoMaximo));
        }

        if (comodidades != null && !comodidades.isEmpty()) {
            Join<Hotel, String> comodidadeJoin = hotel.join("comodidades");
            predicate = cb.and(predicate, comodidadeJoin.in(comodidades));
        }

        if (avaliacaoMinima != null) {
            predicate = cb.and(predicate, cb.greaterThanOrEqualTo(hotel.get("mediaAvaliacao"), avaliacaoMinima));
        }

        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public <S extends Hotel> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends Hotel> List<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            entityManager.persist(entity);
        }
        return (List<S>) entities;
    }

    @Override
    public Optional<Hotel> findById(Long aLong) {
        Hotel hotel = entityManager.find(Hotel.class, aLong);
        return Optional.ofNullable(hotel);
    }

    @Override
    public boolean existsById(Long aLong) {
        return entityManager.find(Hotel.class, aLong) != null;
    }

    @Override
    public List<Hotel> findAll() {
        TypedQuery<Hotel> query = entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class);
        return query.getResultList();
    }

    @Override
    public List<Hotel> findAllById(Iterable<Long> longs) {
        TypedQuery<Hotel> query = entityManager.createQuery("SELECT h FROM Hotel h WHERE h.id IN :ids", Hotel.class);
        query.setParameter("ids", longs);
        return query.getResultList();
    }

    @Override
    public long count() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(h) FROM Hotel h", Long.class);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long aLong) {
        Hotel hotel = entityManager.find(Hotel.class, aLong);
        if (hotel != null) {
            entityManager.remove(hotel);
        }
    }

    @Override
    public void delete(Hotel entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hotel> entities) {
        for (Hotel entity : entities) {
            entityManager.remove(entity);
        }
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Hotel").executeUpdate();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Hotel> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Hotel> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Hotel getOne(Long aLong) {
        return null;
    }

    @Override
    public Hotel getById(Long aLong) {
        return null;
    }

    public Hotel getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Hotel> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Hotel> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Hotel> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Hotel> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Hotel> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Hotel> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Hotel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Hotel> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return null;
    }
}