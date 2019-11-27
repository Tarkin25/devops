package ch.noseryoung.devops.primes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/primes")
public class PrimeController {

    private PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/is-prime")
    public ResponseEntity<Boolean> isPrime(@RequestParam Long number) {
        Boolean isPrime = primeService.isPrimeNumber(number);

        return new ResponseEntity<>(isPrime, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Long>> getPrimes(@RequestParam(required = false) Long minInclusive, @RequestParam Long maxInclusive) {
        List<Long> primes;

        if(minInclusive == null) {
            primes = primeService.getPrimes(maxInclusive);
        } else {
            primes = primeService.getPrimes(minInclusive, maxInclusive);
        }

        return new ResponseEntity<>(primes, HttpStatus.OK);
    }
}
