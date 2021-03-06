package hello.solutionA;

import hello.Greeting;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static hello.Greeting.TEMPLATE_V1;
import static hello.Greeting.TEMPLATE_V2;

/**
 * 1 service, 2 API versions
 *
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@RestController("AController")
@EnableSwagger2
@RequestMapping("a")
@EnableDiscoveryClient
public class GreetingController {


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting",
            produces = "application/json"
    )
    public Greeting greeting(@RequestParam(value = "name") String name) {

        return new Greeting(String.format(TEMPLATE_V1, name));
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting",
            produces = "application/json",
            headers = "api-version=2"
    )
    public Greeting greetingWithAge(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "age") int age)
    {
        return new Greeting(String.format(TEMPLATE_V2, name, age));
    }

}
