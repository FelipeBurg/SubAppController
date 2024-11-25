package ProjArq.ControlSubApp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

@Configuration
public class RabbitMQConfig {

    private static final String QUEUE_NAME = "scaa.v1.subscription-update.save-signature";

    // Declaração da fila como bean
    @Bean
    public Queue cacheQueue() {
        return new Queue(QUEUE_NAME, true); // Fila durável
    }

    // Bean para o nome da fila em String
    @Bean
    public String queueName() {
        return QUEUE_NAME;
    }
}
