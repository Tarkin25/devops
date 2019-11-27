package ch.noseryoung.devops.primes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrimeServiceImplTest {

    @Autowired
    private PrimeServiceImpl primeService;

    @Test
    public void isPrimeNumber_numberMinus1_expectFalse() {
        Assertions.assertThat(primeService.isPrimeNumber(-1L)).isFalse();
    }

    @Test
    public void isPrimeNumber_number0_expectFalse() {
        Assertions.assertThat(primeService.isPrimeNumber(0L)).isFalse();
    }

    @Test
    public void isPrimeNumber_number1_expectFalse() {
        Assertions.assertThat(primeService.isPrimeNumber(1L)).isFalse();
    }

    @Test
    public void isPrime_number2_expectTrue() {
        Assertions.assertThat(primeService.isPrimeNumber(2L)).isTrue();
    }

    @Test
    public void getPrimes_maxInclusive11_expect2_3_5_7_11() {
        Assertions.assertThat(primeService.getPrimes(11L)).isNotEmpty().containsExactly(2L, 3L, 5L, 7L, 11L);
    }

    @Test
    public void getPrimes_maxInclusiveMinus1_expectEmpty() {
        Assertions.assertThat(primeService.getPrimes(-1L)).isEmpty();
    }

    @Test
    public void getPrimes_maxInclusive0_expectEmpty() {
        Assertions.assertThat(primeService.getPrimes(0L)).isEmpty();
    }

    @Test
    public void getPrimes_maxInclusive1_expectEmpty() {
        Assertions.assertThat(primeService.getPrimes(1L)).isEmpty();
    }

    @Test
    public void getPrimes_maxInclusiveMinus1_minInclusiveMinus2_expectEmpty() {
        Assertions.assertThat(primeService.getPrimes(-1L, -2L)).isEmpty();
    }

    @Test
    public void getPrimes_minInclusiveMinus1_maxInclusive3_expect2_3() {
        Assertions.assertThat(primeService.getPrimes(-1L, 3L)).isNotEmpty().containsExactly(2L, 3L);
    }

    @Test
    public void getPrimes_minInclusive5_maxInclusive2_expectEmpty() {
        Assertions.assertThat(primeService.getPrimes(5L, 2L)).isEmpty();
    }

    @Test
    public void getPrimes_minInclusive2_maxInclusive2_expect2() {
        Assertions.assertThat(primeService.getPrimes(2L, 2L)).containsExactly(2L);
    }

    @Test
    public void getPrimes_maxInclusive11_minInclusive5_expect5_7_11() {
        Assertions.assertThat(primeService.getPrimes(5L, 11L)).isNotEmpty().containsExactly(5L, 7L, 11L);
    }
}