package sv.edu.udb.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CartEventConsumer {

    @RabbitListener(queues = "cart.queue")
    public void listen(String message) {
        System.out.println("📩 Evento recibido: " + message);
    }
}
