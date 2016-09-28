package example.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import test.FunctionalTest;

import java.net.URI;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Category(FunctionalTest.class)
public class HelloApplicationTest {

    private static RestTemplate REST_TEMPLATE = new RestTemplate();

    @Value("${local.server.port}")
    private int port;

    private URI getUri(String relativePath) {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(port)
                .path(relativePath)
                .build()
                .toUri();
    }

    @Test
    public void greeting() {
        URI greetingUri = getUri("hello");
        String subject = REST_TEMPLATE.getForObject(greetingUri, String.class);
        Assert.assertEquals("Hello!", subject);
    }

    @Test
    public void greetingWithName() {
        URI greetingUri = getUri("hello/Purple");
        String subject = REST_TEMPLATE.getForObject(greetingUri, String.class);
        Assert.assertEquals("Hello Purple!", subject);
    }

    @Test
    public void unknownEndpoint() {
        URI greetingUri = getUri("doesNotExist");
        try {
            REST_TEMPLATE.getForObject(greetingUri, String.class);
            Assert.fail("expected HttpClientErrorException exception");
        } catch (HttpClientErrorException httpClientErrorException) {
            HttpStatus subject = httpClientErrorException.getStatusCode();
            Assert.assertEquals(HttpStatus.NOT_FOUND, subject);
        }
    }

}
