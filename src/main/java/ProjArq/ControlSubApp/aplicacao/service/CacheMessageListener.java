package ProjArq.ControlSubApp.aplicacao.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheMessageListener {

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
    private final ConnectionFactory connectionFactory;

    private final Queue queue;

    public CacheMessageListener(ConnectionFactory connectionFactory, Queue queue) {
        this.connectionFactory = connectionFactory;
        this.queue = queue; // Bean injetado aqui
    }

    @PostConstruct
    public void setupListener() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(queue.getName()); // Usando o nome da fila injetada
        container.setMessageListener(message -> {
            String messageBody = new String(message.getBody()); // Obtendo o conteúdo da mensagem
            handleCacheInvalidation(messageBody); // Tratando a mensagem
        });
        container.start(); // Inicia o container
    }

    public void handleCacheInvalidation(String message) {
        cache.remove(message);
        System.out.println("Cache invalidado para o appId: " + message);
    }

    public String getFromCache(String appId) {
        return cache.get(appId);
    }

    public void addToCache(String appId, String validity) {
        cache.put(appId, validity);
    }
}
