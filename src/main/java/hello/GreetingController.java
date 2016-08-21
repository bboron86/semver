package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO bartoszb add description
 *
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@RestController
@EnableSwagger2
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    private static final String template = "Hello, %s!";
    private static final String templateV2 = "Hello, %s, age %d!";


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting",
//            headers = "Accept=application/vnd.bb.v1"
            produces = "application/vnd.bb-v1+json"
    )
    public Greeting greetingOld(@RequestParam(value = "name") String name) {
        return getOldGreeting(name);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting",
//            headers = "api-version=1.1"
//            headers = "Accept=application/vnd.bb.v1.*"
            produces = "application/vnd.bb-v1.1+json"
    )
    public Greeting greetingNew(@RequestParam(value = "name") String name) {
        return getNewGreeting(name, 0);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting",
//            headers = "api-version=2.0"
            produces = "application/vnd.bb-v2+json"
    )
    public Greeting greetingNewer(@RequestParam(value = "name") String name) {
        return getNewGreeting(name, -1);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "v2/greeting"
    )
    public Greeting greetingVersioned(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "age") int age) {
        return getNewGreeting(name, age);
    }



    private Greeting getOldGreeting(String name) {
        return new Greeting(String.format(template, name));
    }

    private Greeting getNewGreeting(String name, int age) {
        return new Greeting(String.format(templateV2, name, age));
    }
}
