package ch.noseryoung.devops.fibonacci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {

    private FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }

    @GetMapping("/limit")
    public ResponseEntity<List<Long>> getFibonacci(@RequestParam Long limit) {
        List<Long> fibonacciNumbers = fibonacciService.getFibonacciNumbersLimit(limit);

        return new ResponseEntity<>(fibonacciNumbers, HttpStatus.OK);
    }

    @GetMapping("/iterations")
    public ResponseEntity<List<Long>> getFibonacciNumbersIterations(@RequestParam Integer iterations) {
        List<Long> fibonacciNumbers = fibonacciService.getFibonacciNumbersIterations(iterations);

        return new ResponseEntity<>(fibonacciNumbers, HttpStatus.OK);
    }
}
