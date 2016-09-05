package hello.solutionA;

import hello.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
}
