package ch.noseryoung.devops.fibonacci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/limit/{limit}")
    public ResponseEntity<List<BigInteger>> getFibonacci(@PathVariable BigInteger limit) {
        List<BigInteger> fibonacciNumbers = fibonacciService.getFibonacciNumbersLimit(limit);

        return new ResponseEntity<>(fibonacciNumbers, HttpStatus.OK);
    }

    @GetMapping("/iterations/{iterations}")
    public ResponseEntity<List<BigInteger>> getFibonacciNumbersIterations(@PathVariable Integer iterations) {
        List<BigInteger> fibonacciNumbers = fibonacciService.getFibonacciNumbersIterations(iterations);

        return new ResponseEntity<>(fibonacciNumbers, HttpStatus.OK);
    }
}
