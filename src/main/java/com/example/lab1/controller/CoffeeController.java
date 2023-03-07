package com.example.lab1.controller;

import com.example.lab1.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class CoffeeController {
    AtomicInteger counter = new AtomicInteger(1);
    @GetMapping("/coffeeLover")
    public String coffee(){
        return "I like coffee!";
    }
    @GetMapping("/coffee")
    public Coffee getCoffee(@RequestParam(value = "name", defaultValue = "latte") String name) {

        return new Coffee(counter.incrementAndGet(), name);
    }
}
