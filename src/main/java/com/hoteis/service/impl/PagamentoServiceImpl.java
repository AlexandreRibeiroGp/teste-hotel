package com.hoteis.service.impl;

import com.hoteis.dto.PagamentoDto;
import com.hoteis.mapper.PagamentoMapper;
import com.hoteis.model.Pagamento;
import com.hoteis.repository.PagamentoRepository;
import com.hoteis.repository.impl.PagamentoRepositoryImpl;
import com.hoteis.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagamentoServiceImpl implements PagamentoService {



    private final PagamentoRepository pagamentoRepository;
    private final PagamentoMapper pagamentoMapper;

    @Autowired
    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository, PagamentoMapper pagamentoMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoMapper = pagamentoMapper;
    }


    @Transactional
    @Override
    public PagamentoDto criarPagamento(PagamentoDto pagamentoDto) {
        Pagamento pagamento = pagamentoMapper.toEntity(pagamentoDto);
        pagamento = pagamentoRepository.save(pagamento);
        return pagamentoMapper.toDto(pagamento);
    }
}
