package example.environment;

import test.UnitTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(UnitTest.class)
public class EnvironmentTest {

    @BeforeClass
    public static void setup() {
        Environment.INSTANCE.set("FOO", "BAR");
    }

    @Test
    public void environment() {
        Assert.assertEquals("BAR", Environment.INSTANCE.get("FOO"));
    }

}
