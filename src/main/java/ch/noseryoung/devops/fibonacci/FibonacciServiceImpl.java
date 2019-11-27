package ch.noseryoung.devops.fibonacci;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public List<Long> getFibonacciNumbersLimit(Long limit) {
        List<Long> fibonacciNumbers = new LinkedList<>();

        Long lastFib=0L, fib=1L;
        Long temp;

        while(fib <= limit) {
            fibonacciNumbers.add(fib);

            temp = fib;

            fib += lastFib;

            lastFib = temp;
        }

        return fibonacciNumbers;
    }

    @Override
    public List<Long> getFibonacciNumbersIterations(Integer iterations) {
        List<Long> fibonacciNumbers = new ArrayList<>(iterations);

        Long lastFib=0L, fib = 1L;
        Long temp;

        for(int i=0;i<iterations;i++) {
            fibonacciNumbers.add(fib);

            temp = fib;

            fib += lastFib;

            lastFib = temp;
        }

        return fibonacciNumbers;
    }
}
