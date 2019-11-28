package ch.noseryoung.devops.primes;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrimeIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @org.junit.jupiter.api.Test
    public void isPrime_numberMinus1_expectFalse() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes/is-prime?number={num}", -1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @org.junit.jupiter.api.Test
    public void isPrime_number0_expectFalse() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes/is-prime?number={num}", 0L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @org.junit.jupiter.api.Test
    public void isPrime_number1_expectFalse() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes/is-prime?number={num}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @org.junit.jupiter.api.Test
    public void isPrime_number11_expectTrue() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes/is-prime?number={num}", 11)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_maxInclusiveMinus1_expectEmpty() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?maxInclusive={num}", -1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_maxInclusive0_expectEmpty() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?maxInclusive={num}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_maxInclusive1_expectEmpty() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?maxInclusive={num}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_maxInclusive11_expect2_3_5_7_11() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?maxInclusive={num}", 11)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3]").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4]").value(11));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_minInclusiveMinus1_maxInclusiveMinus2_expectEmpty() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?minInclusive={min}&maxInclusive={max}", -1, -2)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_minInclusiveMinus1_maxInclusive3_expect2_3() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?minInclusive={min}&maxInclusive={max}", -1, 3)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(3));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_minInclusive5_maxInclusive2_expectEmpty() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?minInclusive={min}&maxInclusive={max}", 5, 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }

    @org.junit.jupiter.api.Test
    public void getPrimes_minInclusive2_maxInclusive2_expect2() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?minInclusive={min}&maxInclusive={max}", 2, 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(2));
    }

    @Test
    public void getPrimes_minInclusive5_maxInclusive11_expect5_7_11() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes?minInclusive={min}&maxInclusive={max}", 5, 11)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2]").value(11));
    }

}
