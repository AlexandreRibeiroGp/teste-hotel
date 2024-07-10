package com.hoteis.repository;

import com.hoteis.model.Notificacao;
import com.hoteis.model.Reserva;
import com.hoteis.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository {

    Reserva save(Reserva reserva);

    List<Reserva> findAll();

}