package example.prime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
class PrimeController {

    @Autowired
    PrimeService primeService;

    @RequestMapping("/prime/{number}")
    boolean getProduct(@PathVariable BigInteger number) {
        return primeService.isPrime(number);
    }

}
