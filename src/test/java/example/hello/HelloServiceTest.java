package example.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.UnitTest;

@Category(UnitTest.class)
public class HelloServiceTest {

    private HelloService helloService = new HelloService();

    @Test
    public void greeting() {
        String subject = helloService.greeting();
        Assert.assertEquals("Hello!", subject);
    }

    @Test
    public void greetingWithName() {
        String subject =  helloService.greeting("Purple");
        Assert.assertEquals("Hello Purple!", subject);
    }

}
