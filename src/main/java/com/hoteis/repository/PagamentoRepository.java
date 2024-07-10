package com.hoteis.repository;


import com.hoteis.model.Pagamento;
import com.hoteis.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Pagamento save(Pagamento pagamento);
}