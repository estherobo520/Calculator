package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {

    @InjectMocks
    CalculatorService calculatorService;

    @Test
    public void add_shouldReturn2_when1And1IsPassedIn() {
        int actual = calculatorService.add(1,1);

        assertEquals(2, actual);
    }

    @Test
    public void add_shouldReturn4_when2And2IsPassedIn() {
        int actual = calculatorService.add(2,2);

        assertEquals(4, actual);
    }

    @Test
    public void add_shouldReturn10_when8And2IsPassedIn() {
        int actual = calculatorService.add(8,2);

        assertEquals(10, actual);
    }

    @Test
    public void subtract_shouldReturn2_when4And2IsPassedIn() {
        int actual = calculatorService.subtract(4,2);

        assertEquals(2, actual);
    }

    @Test
    public void subtract_shouldReturn4_when6And2IsPassedIn() {
        int actual = calculatorService.subtract(6,2);

        assertEquals(4, actual);
    }

    @Test
    public void subtract_shouldReturn10_when12And2IsPassedIn() {
        int actual = calculatorService.subtract(15,5);

        assertEquals(10, actual);
    }

}