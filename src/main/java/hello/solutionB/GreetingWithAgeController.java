package hello.solutionB;

import hello.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static hello.Greeting.TEMPLATE_V2;

/**
 * 1 service, 2 API versions
 *
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@RestController
@EnableSwagger2
@RequestMapping("b")
public class GreetingWithAgeController {


    @RequestMapping(
            method = RequestMethod.GET,
            value = "v2/greeting",
            produces = "application/json"
    )
    public Greeting greetingWithAge(@RequestParam(value = "name") String name)
    {
        return new Greeting(String.format(TEMPLATE_V2, name, 0));
    }

}
