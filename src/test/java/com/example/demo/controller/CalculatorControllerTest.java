package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

    @Mock
    CalculatorService mockCalculatorService;

    @InjectMocks
    CalculatorController calculatorController;

    //@SneakyThrows(Exception.class)
    @Before
    public void setUp() throws Exception{

        when(mockCalculatorService.add(anyInt(), anyInt())).thenReturn(2);
        when(mockCalculatorService.subtract(anyInt(), anyInt())).thenReturn(2);
        when(mockCalculatorService.multiply(anyInt(), anyInt())).thenReturn(2);
        when(mockCalculatorService.divide(anyInt(), anyInt())).thenThrow(Exception.class);
    }

    @Test
    public void add_shouldReturn1_when1and1ArePassed() {
        int actual = calculatorController.add(1,1);
        assertEquals(2, actual);
    }

    @Test
    public void add_shouldCallCalculatorService_withCorrectParameters() {
        calculatorController.add(2,3);
        verify(mockCalculatorService).add(2,3);
        //verify(mockCalculatorService, times(1)).add(2,3);
        //verify(mockCalculatorService.add(anyInt(), eq(3));
        //verifyNoInteractions();
    }

    @Test
    public void add_shouldReturn_whatCalculatorServiceReturns() {
        int actual = calculatorController.add(0,0);
        assertEquals(2, actual);
    }

    @Test
    public void subtract_shouldReturn2_when4and2ArePassed() {
        int actual = calculatorController.subtract(4,2);
        assertEquals(2, actual);
    }

    @Test
    public void subtract_shouldCallCalculatorService_withCorrectParameters() {
        calculatorController.subtract(3,2);
        verify(mockCalculatorService).subtract(3,2);
        //verify(mockCalculatorService, times(1)).add(2,3);
        //verify(mockCalculatorService.add(anyInt(), eq(3));
        //verifyNoInteractions();
    }

    @Test
    public void subtract_shouldReturn_whatCalculatorServiceReturns() {
        int actual = calculatorController.subtract(0,0);
        assertEquals(2, actual);
    }

    @Test
    public void multiply_shouldReturn8_when4and2ArePassed() {
        int actual = calculatorController.multiply(4,2);
        assertEquals(8, actual);
    }

    @Test
    public void multiply_shouldCallCalculatorService_withCorrectParameters() {
        calculatorController.multiply(3,2);
        verify(mockCalculatorService).multiply(3,2);
    }

    @Test
    public void multiply_shouldReturn_whatCalculatorServiceReturns() {
        int actual = calculatorController.multiply(0,0);
        assertEquals(2, actual);
    }

    @Test
    public void divide_shouldReturnException_when4and2ArePassed() throws Exception {
        int actual = calculatorController.divide(4,2);
        assertEquals(Exception.class, actual);
    }

    @Test
    public void divide_shouldCallCalculatorService_withCorrectParameters() throws Exception {
        calculatorController.divide(3,2);
        verify(mockCalculatorService).divide(3,2);
    }

    @Test
    public void divide_shouldReturn_whatCalculatorServiceReturns() throws Exception {
        int actual = calculatorController.divide(0,0);
        assertEquals(2, actual);
    }
}