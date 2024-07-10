package com.hoteis.repository.impl;

import com.hoteis.model.Reserva;
import com.hoteis.model.Usuario;
import com.hoteis.repository.ReservaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Repository
public class ReservaRepositoryImpl implements ReservaRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            entityManager.persist(reserva);
        } else {
            entityManager.merge(reserva);
        }
        return reserva;
    }
    public List<Reserva> findByHotelId(Long hotelId) {
        String jpql = "SELECT r FROM Reserva r WHERE r.hotelId.id = :hotelId";
        TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);
        query.setParameter("hotelId", hotelId);
        return query.getResultList();
    }

    public List<Reserva> findByHotelIdAndCheckInDateAndCheckOutDate(Long hotelId, LocalDate checkInDate, LocalDate checkOutDate) {
        String jpql = "SELECT r FROM Reserva r WHERE r.hotelId.id = :hotelId " +
                "AND r.checkInDate <= :checkInDate AND r.checkOutDate >= :checkOutDate";
        TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);
        query.setParameter("hotelId", hotelId);
        query.setParameter("checkInDate", checkInDate);
        query.setParameter("checkOutDate", checkOutDate);
        return query.getResultList();
    }

    public List<Reserva> findByUsuarioId(Long usuarioId) {
        String jpql = "SELECT r FROM Reserva r WHERE r.usuario.id = :usuarioId";
        TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);
        query.setParameter("usuarioId", usuarioId);
        return query.getResultList();
    }

    public List<Reserva> findAll() {
        String jpql = "SELECT r FROM Reserva r";
        return entityManager.createQuery(jpql, Reserva.class).getResultList();
    }


}