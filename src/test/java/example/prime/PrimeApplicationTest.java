package example.prime;

import test.SimpleHttpResponse;
import test.TestHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.FunctionalTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Category(FunctionalTest.class)
public class PrimeApplicationTest {

    @Value("${local.server.port}")
    private int port;
    private TestHelper testHelper;

    @Before
    public void setup() {
        testHelper = new TestHelper("localhost", port);
    }

    @Test
    public void prime() {
        SimpleHttpResponse response = testHelper.get("prime/7");
        Assert.assertEquals(200, response.code);
        Assert.assertEquals("true", response.body);
    }

    @Test
    public void notPrime() {
        SimpleHttpResponse response = testHelper.get("prime/6");
        Assert.assertEquals(200, response.code);
        Assert.assertEquals("false", response.body);
    }

    @Test
    public void purple() {
        SimpleHttpResponse response = testHelper.get("prime/purple");
        Assert.assertEquals(400, response.code);
    }

}
