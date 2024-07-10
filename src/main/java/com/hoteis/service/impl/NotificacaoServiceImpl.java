package com.hoteis.service.impl;

import com.hoteis.Enum.ReservaStatusEnum;
import com.hoteis.model.Notificacao;
import com.hoteis.model.Reserva;
import com.hoteis.repository.NotificacaoRepository;
import com.hoteis.service.NotificacaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NotificacaoServiceImpl implements NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private JavaMailSender mailSender;

    public void sendKafkaMessage(String message) {
        kafkaTemplate.send("reservation-status", message);
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    @Override
    public void sendNotification(Reserva reservaId, String message) {

    }

    @Override
    public List<Notificacao> getNotificacoesByReserva(Long reservaId) {
        return notificacaoRepository.findByReservaId(reservaId);
    }
}