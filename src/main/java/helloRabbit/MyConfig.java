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

    private static class ReceiverConfig {

        @Bean
        public Receiver myReceiver1() {
            return new Receiver(1);
        }

        @Bean
        public Receiver myReceiver2() {
            return new Receiver(2);
        }
    }

    @Bean
    public Sender mySender() {
        return new Sender();
    }
}
