package helloRabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO bartoszb add description
 *
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@Configuration
public class MyConfig {

    public static final String QUEUE_NAME = "tut.hello";

    @Bean
    Queue myQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Receiver myReceiver() {
        return new Receiver();
    }

    @Bean
    public Sender mySender() {
        return new Sender();
    }
}
