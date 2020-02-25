package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add/{first}/{second}")
    public int add(@PathVariable("first") int a, @PathVariable("second") int b) {

        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract/{first}/{second}")
    public int subtract(int a, int b) {

        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply/{first}/{second}")
    public int multiply(int a, int b) {

        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide/{first}/{second}")
    public int divide(int a, int b) throws Exception {

        return calculatorService.divide(a, b);
    }
}
