package com.hoteis.service;

import com.hoteis.Enum.ReservaStatusEnum;
import com.hoteis.model.Notificacao;
import com.hoteis.model.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NotificacaoService {
    void sendNotification(Reserva reservaId, String message);
    List<Notificacao> getNotificacoesByReserva(Long reservaId);

    void sendEmail(String to, String subject, String text);

     void sendKafkaMessage(String message);
}