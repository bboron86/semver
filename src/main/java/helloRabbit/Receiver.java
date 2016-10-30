package helloRabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * TODO bartoszb add description
 *
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@RabbitListener(queues = MyConfig.QUEUE_NAME)
public class Receiver {

    private final int instance;

    public Receiver(int instance) {
        this.instance = instance;
    }

    @RabbitHandler
    public void receive(String message) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();

        System.out.println("instance " + this.instance + ": [x] received '" + message + "'");
        doWork(message);

        watch.stop();
        System.out.println("instance " + this.instance + ": [x] done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for (char c : in.toCharArray()) {
            if (c == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
