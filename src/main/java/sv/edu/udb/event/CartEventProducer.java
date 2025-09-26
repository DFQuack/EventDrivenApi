package sv.edu.udb.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CartEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public CartEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEvent(String eventType, Object data) {
        rabbitTemplate.convertAndSend("cart.exchange", "cart.key", eventType + " -> " + data.toString());
    }
}
