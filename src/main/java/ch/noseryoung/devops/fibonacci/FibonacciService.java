package ch.noseryoung.devops.fibonacci;

import java.util.List;

public interface FibonacciService {

    List<Long> getFibonacciNumbersLimit(Long limit);

    List<Long> getFibonacciNumbersIterations(Integer iterations);

}
