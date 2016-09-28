package example.prime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.UnitTest;

import java.math.BigInteger;

@Category(UnitTest.class)
public class PrimeServiceTest {

    private PrimeService primeService = new PrimeService();

    @Test
    public void isPrime() {
        BigInteger number = new BigInteger("7");
        Assert.assertTrue(primeService.isPrime(number));
    }

    @Test
    public void isNotPrime() {
        BigInteger number = new BigInteger("6");
        Assert.assertFalse(primeService.isPrime(number));
    }

    @Test
    public void largePrime() {
        BigInteger number = new BigInteger("115756986668303657898962467957");
        Assert.assertTrue(primeService.isPrime(number));
    }

    @Test
    public void largeNotPrime() {
        BigInteger number = new BigInteger("4901971054862853523");
        Assert.assertFalse(primeService.isPrime(number));
    }

    @Test
    public void negativeNumber() {
        BigInteger number = new BigInteger("-11");
        Assert.assertTrue(primeService.isPrime(number));
    }

}
