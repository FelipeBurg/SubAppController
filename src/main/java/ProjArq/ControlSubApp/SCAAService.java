package ProjArq.ControlSubApp;

import ProjArq.ControlSubApp.aplicacao.service.CacheService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SCAAService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("queueName") // Injetando o nome da fila
    private String queueName;

    // Método que vai escutar a fila de requisição para verificar a assinatura
    @RabbitListener(queues = "${queue.name}")
    public void verificarAssinatura(long codAss) {
        boolean validade = consultaSCAA(codAss);

        // Atualiza a cache com a validade da assinatura
        cacheService.updateCache(String.valueOf(codAss), String.valueOf(validade));

        // Envia uma resposta ou notificação para outro sistema, se necessário
        enviarRespostaValidacao(codAss, validade);
    }

    // Método simulado que consulta o SCAA para validar a assinatura
    private boolean consultaSCAA(long codAss) {
        // Aqui, você pode fazer uma consulta real ao SCAA ou outro sistema
        return true; // Simulando que a assinatura está válida
    }

    // Envia uma mensagem para outro micro-serviço ou componente para notificar a atualização
    private void enviarRespostaValidacao(long codAss, boolean validade) {
        // Isso pode ser feito enviando uma mensagem ao RabbitMQ ou outro sistema
        String message = "Assinatura " + codAss + " válida: " + validade;
        rabbitTemplate.convertAndSend(queueName, message); // Usando o nome da fila para enviar a mensagem
    }
}
