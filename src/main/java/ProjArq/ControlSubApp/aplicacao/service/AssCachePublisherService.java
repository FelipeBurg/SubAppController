package ProjArq.ControlSubApp.aplicacao.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class AssCachePublisherService {

    private final AmqpTemplate amqpTemplate;

    public AssCachePublisherService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void notifyAssCache(String message) {
        amqpTemplate.convertAndSend("assCacheUpdateQueue", message); // Envia a mensagem para a fila
    }
}
