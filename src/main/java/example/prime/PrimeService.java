package example.prime;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
class PrimeService {

    boolean isPrime(BigInteger number) {
        return number.isProbablePrime(1);
    }

}
