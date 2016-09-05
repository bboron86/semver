package hello.solutionA;

import hello.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Bartosz Boron, MaibornWolff GmbH
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestGreetingService {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testV1() {
        ResponseEntity<Greeting> response = this.restTemplate.getForEntity("/a/greeting?name={n}", Greeting.class, "Bartosz");
        assertThat("StatusCode should be 200", response.getStatusCode(), is(HttpStatus.OK));
        assertThat("Wrong message", response.getBody().getMessage(), is("Hello, Bartosz!"));
    }

    @Test
    public void testV2() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("api-version", Collections.singletonList("2"));

        ResponseEntity<Greeting> response = this.restTemplate.exchange(
                "/a/greeting?name={n}&age={a}",
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                Greeting.class,
                "Bartosz",
                30
        );
        assertThat("StatusCode should be 200", response.getStatusCode(), is(HttpStatus.OK));
        assertThat("Wrong message", response.getBody().getMessage(), is("Hello, Bartosz, age 30!"));
    }
}
