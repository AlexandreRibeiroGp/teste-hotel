package com.hoteis.repository.impl;

import com.hoteis.model.Pagamento;
import com.hoteis.model.Reserva;
import com.hoteis.repository.PagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class PagamentoRepositoryImpl implements PagamentoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pagamento save(Pagamento pagamento) {
        if (pagamento.getId() == null) {
            entityManager.persist(pagamento);
        } else {
            entityManager.merge(pagamento);
        }
        return pagamento;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pagamento> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Pagamento> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Pagamento> entities) {
        PagamentoRepository.super.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Pagamento> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pagamento getOne(Long aLong) {
        return null;
    }

    @Override
    public Pagamento getById(Long aLong) {
        return null;
    }

    @Override
    public Pagamento getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Pagamento> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Pagamento> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Pagamento> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Pagamento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pagamento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pagamento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Pagamento, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Pagamento> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Pagamento> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Pagamento> findAll() {
        return null;
    }

    @Override
    public List<Pagamento> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Pagamento entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pagamento> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Pagamento> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Pagamento> findAll(Pageable pageable) {
        return null;
    }
}
