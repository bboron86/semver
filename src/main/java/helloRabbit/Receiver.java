package helloRabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * TODO bartoszb add description
 *
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@RabbitListener(queues = MyConfig.QUEUE_NAME)
public class Receiver {

    @RabbitHandler
    public void receive(String message) {
        System.out.println(" [x] Received '" + message + "'");
    }
}
